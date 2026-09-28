package com.smartcropcare.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.smartcropcare.app.data.local.dao.*
import com.smartcropcare.app.data.local.entity.*
import kotlinx.coroutines.CoroutineScope

@Database(
    entities = [
        UserEntity::class,
        CropEntity::class,
        FarmActivityEntity::class,
        IrrigationLogEntity::class,
        FertilizerLogEntity::class,
        DiseaseRecordEntity::class,
        ExpenseEntity::class,
        PestRecordEntity::class
    ],
    version = 5,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun cropDao(): CropDao
    abstract fun farmActivityDao(): FarmActivityDao
    abstract fun logDao(): LogDao
    abstract fun diseaseRecordDao(): DiseaseRecordDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun pestDao(): PestDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `users` (
                        `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        `email` TEXT NOT NULL,
                        `passwordHash` TEXT NOT NULL,
                        `name` TEXT NOT NULL
                    )
                    """.trimIndent()
                )
                db.execSQL("ALTER TABLE `crops` ADD COLUMN `userId` INTEGER NOT NULL DEFAULT 0")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `users` ADD COLUMN `profilePhotoUri` TEXT DEFAULT NULL")
                db.execSQL("ALTER TABLE `users` ADD COLUMN `language` TEXT NOT NULL DEFAULT 'en'")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE `users` ADD COLUMN `phone` TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    """
                    CREATE TABLE IF NOT EXISTS `pest_records` (
                        `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                        `cropId` INTEGER NOT NULL,
                        `date` TEXT NOT NULL,
                        `pestName` TEXT NOT NULL,
                        `damageSymptoms` TEXT NOT NULL,
                        `managementAction` TEXT NOT NULL,
                        `treatmentNotes` TEXT NOT NULL,
                        `imagePath` TEXT
                    )
                    """.trimIndent()
                )
            }
        }

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "smart_crop_care.db"
                )
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5)
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
