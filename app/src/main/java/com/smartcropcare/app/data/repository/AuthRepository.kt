package com.smartcropcare.app.data.repository

import com.smartcropcare.app.data.local.dao.UserDao
import com.smartcropcare.app.data.local.entity.UserEntity
import java.security.MessageDigest
import java.util.Locale

class AuthRepository(private val userDao: UserDao) {

    suspend fun getUserByEmail(email: String): UserEntity? {
        val cleanEmail = email.trim().lowercase(Locale.ROOT)
        return userDao.getUserByEmail(cleanEmail)
    }

    suspend fun getUserById(userId: Long): UserEntity? {
        return userDao.getUserById(userId)
    }

    suspend fun register(name: String, email: String, password: String, phone: String = ""): Result<UserEntity> {
        val cleanEmail = email.trim().lowercase(Locale.ROOT)
        val cleanName = name.trim()
        val cleanPassword = password.trim()

        if (cleanName.isEmpty() || cleanEmail.isEmpty() || cleanPassword.isEmpty()) {
            return Result.failure(IllegalArgumentException("Please fill all required fields"))
        }

        val existing = userDao.getUserByEmail(cleanEmail)
        if (existing != null) {
            return Result.failure(IllegalStateException("Email already registered"))
        }

        val hashedPassword = hashPassword(cleanPassword)
        val user = UserEntity(
            email = cleanEmail,
            passwordHash = hashedPassword,
            name = cleanName,
            phone = phone.trim()
        )
        val id = userDao.insertUser(user)
        return Result.success(user.copy(id = id))
    }

    suspend fun login(email: String, rawPassword: String): Result<UserEntity> {
        val cleanEmail = email.trim().lowercase(Locale.ROOT)
        val cleanPassword = rawPassword.trim()

        val user = userDao.getUserByEmail(cleanEmail)
            ?: return Result.failure(IllegalArgumentException("Invalid email or password"))

        val isMatch = verifyPassword(cleanPassword, rawPassword, user.passwordHash)
        if (!isMatch) {
            return Result.failure(IllegalArgumentException("Invalid email or password"))
        }

        // Automatic backward compatibility migration: if stored hash is legacy plaintext, upgrade to SHA-256
        if (user.passwordHash == rawPassword || user.passwordHash == cleanPassword) {
            val upgradedUser = user.copy(passwordHash = hashPassword(cleanPassword))
            userDao.updateUser(upgradedUser)
        }

        return Result.success(user)
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    fun hashPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun verifyPassword(trimmedRaw: String, originalRaw: String, storedHash: String): Boolean {
        val hashOfTrimmed = hashPassword(trimmedRaw)
        val hashOfOriginal = hashPassword(originalRaw)

        return when {
            storedHash.equals(hashOfTrimmed, ignoreCase = true) -> true
            storedHash.equals(hashOfOriginal, ignoreCase = true) -> true
            storedHash == originalRaw -> true
            storedHash == trimmedRaw -> true
            else -> false
        }
    }
}
