package com.smartcropcare.app.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.smartcropcare.app.data.local.dao.CropDao;
import com.smartcropcare.app.data.local.dao.CropDao_Impl;
import com.smartcropcare.app.data.local.dao.DiseaseRecordDao;
import com.smartcropcare.app.data.local.dao.DiseaseRecordDao_Impl;
import com.smartcropcare.app.data.local.dao.ExpenseDao;
import com.smartcropcare.app.data.local.dao.ExpenseDao_Impl;
import com.smartcropcare.app.data.local.dao.FarmActivityDao;
import com.smartcropcare.app.data.local.dao.FarmActivityDao_Impl;
import com.smartcropcare.app.data.local.dao.LogDao;
import com.smartcropcare.app.data.local.dao.LogDao_Impl;
import com.smartcropcare.app.data.local.dao.PestDao;
import com.smartcropcare.app.data.local.dao.PestDao_Impl;
import com.smartcropcare.app.data.local.dao.UserDao;
import com.smartcropcare.app.data.local.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile CropDao _cropDao;

  private volatile FarmActivityDao _farmActivityDao;

  private volatile LogDao _logDao;

  private volatile DiseaseRecordDao _diseaseRecordDao;

  private volatile ExpenseDao _expenseDao;

  private volatile PestDao _pestDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `passwordHash` TEXT NOT NULL, `name` TEXT NOT NULL, `profilePhotoUri` TEXT, `language` TEXT NOT NULL, `phone` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `crops` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` INTEGER NOT NULL, `name` TEXT NOT NULL, `variety` TEXT NOT NULL, `scientificName` TEXT NOT NULL, `hybridType` TEXT NOT NULL, `plotName` TEXT NOT NULL, `zoneBed` TEXT NOT NULL, `acreage` REAL NOT NULL, `soilType` TEXT NOT NULL, `plantingDate` TEXT NOT NULL, `cropAgeDays` INTEGER NOT NULL, `currentStageIndex` INTEGER NOT NULL, `stageName` TEXT NOT NULL, `stageCompletionPct` INTEGER NOT NULL, `healthScore` INTEGER NOT NULL, `healthStatus` TEXT NOT NULL, `cycleProgressPct` INTEGER NOT NULL, `waterStatus` TEXT NOT NULL, `fertilizerStatus` TEXT NOT NULL, `harvestCountdownDays` INTEGER NOT NULL, `imageResName` TEXT NOT NULL, `imageUri` TEXT, `isActive` INTEGER NOT NULL, `certificateId` TEXT NOT NULL, `estimatedYieldTonPerAcre` REAL NOT NULL, `totalInvestment` REAL NOT NULL, `projectedRevenue` REAL NOT NULL, `soilMoisturePct` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `farm_activities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `time` TEXT NOT NULL, `title` TEXT NOT NULL, `tag` TEXT NOT NULL, `isCompleted` INTEGER NOT NULL, `category` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `irrigation_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `date` TEXT NOT NULL, `litersApplied` INTEGER NOT NULL, `durationMinutes` INTEGER NOT NULL, `method` TEXT NOT NULL, `efficiencyPct` INTEGER NOT NULL, `soilMoisturePct` INTEGER NOT NULL, `notes` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `fertilizer_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `date` TEXT NOT NULL, `nutrientName` TEXT NOT NULL, `dosage` TEXT NOT NULL, `applicationMethod` TEXT NOT NULL, `adherenceStatus` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `disease_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `date` TEXT NOT NULL, `diseaseName` TEXT NOT NULL, `pathogen` TEXT NOT NULL, `confidencePct` REAL NOT NULL, `severityStage` TEXT NOT NULL, `observedSymptoms` TEXT NOT NULL, `organicTreatment` TEXT NOT NULL, `chemicalTreatment` TEXT NOT NULL, `imagePath` TEXT, `status` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `expenses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `date` TEXT NOT NULL, `category` TEXT NOT NULL, `amount` REAL NOT NULL, `description` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `pest_records` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `cropId` INTEGER NOT NULL, `date` TEXT NOT NULL, `pestName` TEXT NOT NULL, `damageSymptoms` TEXT NOT NULL, `managementAction` TEXT NOT NULL, `treatmentNotes` TEXT NOT NULL, `imagePath` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7a5b8d2be009bd85e2ee03b96ad9b22e')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `crops`");
        db.execSQL("DROP TABLE IF EXISTS `farm_activities`");
        db.execSQL("DROP TABLE IF EXISTS `irrigation_logs`");
        db.execSQL("DROP TABLE IF EXISTS `fertilizer_logs`");
        db.execSQL("DROP TABLE IF EXISTS `disease_records`");
        db.execSQL("DROP TABLE IF EXISTS `expenses`");
        db.execSQL("DROP TABLE IF EXISTS `pest_records`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(7);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("passwordHash", new TableInfo.Column("passwordHash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("profilePhotoUri", new TableInfo.Column("profilePhotoUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.smartcropcare.app.data.local.entity.UserEntity).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsCrops = new HashMap<String, TableInfo.Column>(29);
        _columnsCrops.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("variety", new TableInfo.Column("variety", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("scientificName", new TableInfo.Column("scientificName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("hybridType", new TableInfo.Column("hybridType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("plotName", new TableInfo.Column("plotName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("zoneBed", new TableInfo.Column("zoneBed", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("acreage", new TableInfo.Column("acreage", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("soilType", new TableInfo.Column("soilType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("plantingDate", new TableInfo.Column("plantingDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("cropAgeDays", new TableInfo.Column("cropAgeDays", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("currentStageIndex", new TableInfo.Column("currentStageIndex", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("stageName", new TableInfo.Column("stageName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("stageCompletionPct", new TableInfo.Column("stageCompletionPct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("healthScore", new TableInfo.Column("healthScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("healthStatus", new TableInfo.Column("healthStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("cycleProgressPct", new TableInfo.Column("cycleProgressPct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("waterStatus", new TableInfo.Column("waterStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("fertilizerStatus", new TableInfo.Column("fertilizerStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("harvestCountdownDays", new TableInfo.Column("harvestCountdownDays", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("imageResName", new TableInfo.Column("imageResName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("imageUri", new TableInfo.Column("imageUri", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("certificateId", new TableInfo.Column("certificateId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("estimatedYieldTonPerAcre", new TableInfo.Column("estimatedYieldTonPerAcre", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("totalInvestment", new TableInfo.Column("totalInvestment", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("projectedRevenue", new TableInfo.Column("projectedRevenue", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCrops.put("soilMoisturePct", new TableInfo.Column("soilMoisturePct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCrops = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCrops = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCrops = new TableInfo("crops", _columnsCrops, _foreignKeysCrops, _indicesCrops);
        final TableInfo _existingCrops = TableInfo.read(db, "crops");
        if (!_infoCrops.equals(_existingCrops)) {
          return new RoomOpenHelper.ValidationResult(false, "crops(com.smartcropcare.app.data.local.entity.CropEntity).\n"
                  + " Expected:\n" + _infoCrops + "\n"
                  + " Found:\n" + _existingCrops);
        }
        final HashMap<String, TableInfo.Column> _columnsFarmActivities = new HashMap<String, TableInfo.Column>(7);
        _columnsFarmActivities.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("time", new TableInfo.Column("time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("tag", new TableInfo.Column("tag", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFarmActivities.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFarmActivities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFarmActivities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFarmActivities = new TableInfo("farm_activities", _columnsFarmActivities, _foreignKeysFarmActivities, _indicesFarmActivities);
        final TableInfo _existingFarmActivities = TableInfo.read(db, "farm_activities");
        if (!_infoFarmActivities.equals(_existingFarmActivities)) {
          return new RoomOpenHelper.ValidationResult(false, "farm_activities(com.smartcropcare.app.data.local.entity.FarmActivityEntity).\n"
                  + " Expected:\n" + _infoFarmActivities + "\n"
                  + " Found:\n" + _existingFarmActivities);
        }
        final HashMap<String, TableInfo.Column> _columnsIrrigationLogs = new HashMap<String, TableInfo.Column>(9);
        _columnsIrrigationLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("litersApplied", new TableInfo.Column("litersApplied", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("durationMinutes", new TableInfo.Column("durationMinutes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("method", new TableInfo.Column("method", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("efficiencyPct", new TableInfo.Column("efficiencyPct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("soilMoisturePct", new TableInfo.Column("soilMoisturePct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsIrrigationLogs.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIrrigationLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIrrigationLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIrrigationLogs = new TableInfo("irrigation_logs", _columnsIrrigationLogs, _foreignKeysIrrigationLogs, _indicesIrrigationLogs);
        final TableInfo _existingIrrigationLogs = TableInfo.read(db, "irrigation_logs");
        if (!_infoIrrigationLogs.equals(_existingIrrigationLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "irrigation_logs(com.smartcropcare.app.data.local.entity.IrrigationLogEntity).\n"
                  + " Expected:\n" + _infoIrrigationLogs + "\n"
                  + " Found:\n" + _existingIrrigationLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsFertilizerLogs = new HashMap<String, TableInfo.Column>(7);
        _columnsFertilizerLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("nutrientName", new TableInfo.Column("nutrientName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("dosage", new TableInfo.Column("dosage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("applicationMethod", new TableInfo.Column("applicationMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFertilizerLogs.put("adherenceStatus", new TableInfo.Column("adherenceStatus", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFertilizerLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFertilizerLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFertilizerLogs = new TableInfo("fertilizer_logs", _columnsFertilizerLogs, _foreignKeysFertilizerLogs, _indicesFertilizerLogs);
        final TableInfo _existingFertilizerLogs = TableInfo.read(db, "fertilizer_logs");
        if (!_infoFertilizerLogs.equals(_existingFertilizerLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "fertilizer_logs(com.smartcropcare.app.data.local.entity.FertilizerLogEntity).\n"
                  + " Expected:\n" + _infoFertilizerLogs + "\n"
                  + " Found:\n" + _existingFertilizerLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsDiseaseRecords = new HashMap<String, TableInfo.Column>(12);
        _columnsDiseaseRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("diseaseName", new TableInfo.Column("diseaseName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("pathogen", new TableInfo.Column("pathogen", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("confidencePct", new TableInfo.Column("confidencePct", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("severityStage", new TableInfo.Column("severityStage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("observedSymptoms", new TableInfo.Column("observedSymptoms", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("organicTreatment", new TableInfo.Column("organicTreatment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("chemicalTreatment", new TableInfo.Column("chemicalTreatment", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("imagePath", new TableInfo.Column("imagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDiseaseRecords.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDiseaseRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDiseaseRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDiseaseRecords = new TableInfo("disease_records", _columnsDiseaseRecords, _foreignKeysDiseaseRecords, _indicesDiseaseRecords);
        final TableInfo _existingDiseaseRecords = TableInfo.read(db, "disease_records");
        if (!_infoDiseaseRecords.equals(_existingDiseaseRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "disease_records(com.smartcropcare.app.data.local.entity.DiseaseRecordEntity).\n"
                  + " Expected:\n" + _infoDiseaseRecords + "\n"
                  + " Found:\n" + _existingDiseaseRecords);
        }
        final HashMap<String, TableInfo.Column> _columnsExpenses = new HashMap<String, TableInfo.Column>(6);
        _columnsExpenses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExpenses.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExpenses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExpenses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExpenses = new TableInfo("expenses", _columnsExpenses, _foreignKeysExpenses, _indicesExpenses);
        final TableInfo _existingExpenses = TableInfo.read(db, "expenses");
        if (!_infoExpenses.equals(_existingExpenses)) {
          return new RoomOpenHelper.ValidationResult(false, "expenses(com.smartcropcare.app.data.local.entity.ExpenseEntity).\n"
                  + " Expected:\n" + _infoExpenses + "\n"
                  + " Found:\n" + _existingExpenses);
        }
        final HashMap<String, TableInfo.Column> _columnsPestRecords = new HashMap<String, TableInfo.Column>(8);
        _columnsPestRecords.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("cropId", new TableInfo.Column("cropId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("pestName", new TableInfo.Column("pestName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("damageSymptoms", new TableInfo.Column("damageSymptoms", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("managementAction", new TableInfo.Column("managementAction", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("treatmentNotes", new TableInfo.Column("treatmentNotes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPestRecords.put("imagePath", new TableInfo.Column("imagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPestRecords = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPestRecords = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPestRecords = new TableInfo("pest_records", _columnsPestRecords, _foreignKeysPestRecords, _indicesPestRecords);
        final TableInfo _existingPestRecords = TableInfo.read(db, "pest_records");
        if (!_infoPestRecords.equals(_existingPestRecords)) {
          return new RoomOpenHelper.ValidationResult(false, "pest_records(com.smartcropcare.app.data.local.entity.PestRecordEntity).\n"
                  + " Expected:\n" + _infoPestRecords + "\n"
                  + " Found:\n" + _existingPestRecords);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "7a5b8d2be009bd85e2ee03b96ad9b22e", "3d23fa770f897a30d71e619350696abf");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","crops","farm_activities","irrigation_logs","fertilizer_logs","disease_records","expenses","pest_records");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `crops`");
      _db.execSQL("DELETE FROM `farm_activities`");
      _db.execSQL("DELETE FROM `irrigation_logs`");
      _db.execSQL("DELETE FROM `fertilizer_logs`");
      _db.execSQL("DELETE FROM `disease_records`");
      _db.execSQL("DELETE FROM `expenses`");
      _db.execSQL("DELETE FROM `pest_records`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CropDao.class, CropDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FarmActivityDao.class, FarmActivityDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LogDao.class, LogDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DiseaseRecordDao.class, DiseaseRecordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExpenseDao.class, ExpenseDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PestDao.class, PestDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CropDao cropDao() {
    if (_cropDao != null) {
      return _cropDao;
    } else {
      synchronized(this) {
        if(_cropDao == null) {
          _cropDao = new CropDao_Impl(this);
        }
        return _cropDao;
      }
    }
  }

  @Override
  public FarmActivityDao farmActivityDao() {
    if (_farmActivityDao != null) {
      return _farmActivityDao;
    } else {
      synchronized(this) {
        if(_farmActivityDao == null) {
          _farmActivityDao = new FarmActivityDao_Impl(this);
        }
        return _farmActivityDao;
      }
    }
  }

  @Override
  public LogDao logDao() {
    if (_logDao != null) {
      return _logDao;
    } else {
      synchronized(this) {
        if(_logDao == null) {
          _logDao = new LogDao_Impl(this);
        }
        return _logDao;
      }
    }
  }

  @Override
  public DiseaseRecordDao diseaseRecordDao() {
    if (_diseaseRecordDao != null) {
      return _diseaseRecordDao;
    } else {
      synchronized(this) {
        if(_diseaseRecordDao == null) {
          _diseaseRecordDao = new DiseaseRecordDao_Impl(this);
        }
        return _diseaseRecordDao;
      }
    }
  }

  @Override
  public ExpenseDao expenseDao() {
    if (_expenseDao != null) {
      return _expenseDao;
    } else {
      synchronized(this) {
        if(_expenseDao == null) {
          _expenseDao = new ExpenseDao_Impl(this);
        }
        return _expenseDao;
      }
    }
  }

  @Override
  public PestDao pestDao() {
    if (_pestDao != null) {
      return _pestDao;
    } else {
      synchronized(this) {
        if(_pestDao == null) {
          _pestDao = new PestDao_Impl(this);
        }
        return _pestDao;
      }
    }
  }
}
