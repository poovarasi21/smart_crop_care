package com.smartcropcare.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.smartcropcare.app.data.local.entity.CropEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CropDao_Impl implements CropDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CropEntity> __insertionAdapterOfCropEntity;

  private final EntityDeletionOrUpdateAdapter<CropEntity> __deletionAdapterOfCropEntity;

  private final EntityDeletionOrUpdateAdapter<CropEntity> __updateAdapterOfCropEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateHealth;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMoisture;

  public CropDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCropEntity = new EntityInsertionAdapter<CropEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `crops` (`id`,`userId`,`name`,`variety`,`scientificName`,`hybridType`,`plotName`,`zoneBed`,`acreage`,`soilType`,`plantingDate`,`cropAgeDays`,`currentStageIndex`,`stageName`,`stageCompletionPct`,`healthScore`,`healthStatus`,`cycleProgressPct`,`waterStatus`,`fertilizerStatus`,`harvestCountdownDays`,`imageResName`,`imageUri`,`isActive`,`certificateId`,`estimatedYieldTonPerAcre`,`totalInvestment`,`projectedRevenue`,`soilMoisturePct`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CropEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        statement.bindString(3, entity.getName());
        statement.bindString(4, entity.getVariety());
        statement.bindString(5, entity.getScientificName());
        statement.bindString(6, entity.getHybridType());
        statement.bindString(7, entity.getPlotName());
        statement.bindString(8, entity.getZoneBed());
        statement.bindDouble(9, entity.getAcreage());
        statement.bindString(10, entity.getSoilType());
        statement.bindString(11, entity.getPlantingDate());
        statement.bindLong(12, entity.getCropAgeDays());
        statement.bindLong(13, entity.getCurrentStageIndex());
        statement.bindString(14, entity.getStageName());
        statement.bindLong(15, entity.getStageCompletionPct());
        statement.bindLong(16, entity.getHealthScore());
        statement.bindString(17, entity.getHealthStatus());
        statement.bindLong(18, entity.getCycleProgressPct());
        statement.bindString(19, entity.getWaterStatus());
        statement.bindString(20, entity.getFertilizerStatus());
        statement.bindLong(21, entity.getHarvestCountdownDays());
        statement.bindString(22, entity.getImageResName());
        if (entity.getImageUri() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getImageUri());
        }
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(24, _tmp);
        statement.bindString(25, entity.getCertificateId());
        statement.bindDouble(26, entity.getEstimatedYieldTonPerAcre());
        statement.bindDouble(27, entity.getTotalInvestment());
        statement.bindDouble(28, entity.getProjectedRevenue());
        statement.bindLong(29, entity.getSoilMoisturePct());
      }
    };
    this.__deletionAdapterOfCropEntity = new EntityDeletionOrUpdateAdapter<CropEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `crops` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CropEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCropEntity = new EntityDeletionOrUpdateAdapter<CropEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `crops` SET `id` = ?,`userId` = ?,`name` = ?,`variety` = ?,`scientificName` = ?,`hybridType` = ?,`plotName` = ?,`zoneBed` = ?,`acreage` = ?,`soilType` = ?,`plantingDate` = ?,`cropAgeDays` = ?,`currentStageIndex` = ?,`stageName` = ?,`stageCompletionPct` = ?,`healthScore` = ?,`healthStatus` = ?,`cycleProgressPct` = ?,`waterStatus` = ?,`fertilizerStatus` = ?,`harvestCountdownDays` = ?,`imageResName` = ?,`imageUri` = ?,`isActive` = ?,`certificateId` = ?,`estimatedYieldTonPerAcre` = ?,`totalInvestment` = ?,`projectedRevenue` = ?,`soilMoisturePct` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CropEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getUserId());
        statement.bindString(3, entity.getName());
        statement.bindString(4, entity.getVariety());
        statement.bindString(5, entity.getScientificName());
        statement.bindString(6, entity.getHybridType());
        statement.bindString(7, entity.getPlotName());
        statement.bindString(8, entity.getZoneBed());
        statement.bindDouble(9, entity.getAcreage());
        statement.bindString(10, entity.getSoilType());
        statement.bindString(11, entity.getPlantingDate());
        statement.bindLong(12, entity.getCropAgeDays());
        statement.bindLong(13, entity.getCurrentStageIndex());
        statement.bindString(14, entity.getStageName());
        statement.bindLong(15, entity.getStageCompletionPct());
        statement.bindLong(16, entity.getHealthScore());
        statement.bindString(17, entity.getHealthStatus());
        statement.bindLong(18, entity.getCycleProgressPct());
        statement.bindString(19, entity.getWaterStatus());
        statement.bindString(20, entity.getFertilizerStatus());
        statement.bindLong(21, entity.getHarvestCountdownDays());
        statement.bindString(22, entity.getImageResName());
        if (entity.getImageUri() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getImageUri());
        }
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(24, _tmp);
        statement.bindString(25, entity.getCertificateId());
        statement.bindDouble(26, entity.getEstimatedYieldTonPerAcre());
        statement.bindDouble(27, entity.getTotalInvestment());
        statement.bindDouble(28, entity.getProjectedRevenue());
        statement.bindLong(29, entity.getSoilMoisturePct());
        statement.bindLong(30, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateStage = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE crops SET currentStageIndex = ?, stageName = ?, stageCompletionPct = ?, harvestCountdownDays = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateHealth = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE crops SET healthScore = ?, healthStatus = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMoisture = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE crops SET soilMoisturePct = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertCrop(final CropEntity crop, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCropEntity.insertAndReturnId(crop);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<CropEntity> crops,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCropEntity.insert(crops);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteCrop(final CropEntity crop, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCropEntity.handle(crop);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCrop(final CropEntity crop, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCropEntity.handle(crop);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStage(final long cropId, final int stageIndex, final String stageName,
      final int completionPct, final int daysToHarvest,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStage.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, stageIndex);
        _argIndex = 2;
        _stmt.bindString(_argIndex, stageName);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, completionPct);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, daysToHarvest);
        _argIndex = 5;
        _stmt.bindLong(_argIndex, cropId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateStage.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateHealth(final long cropId, final int healthScore, final String healthStatus,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateHealth.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, healthScore);
        _argIndex = 2;
        _stmt.bindString(_argIndex, healthStatus);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, cropId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateHealth.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMoisture(final long cropId, final int moisturePct,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMoisture.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, moisturePct);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, cropId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateMoisture.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CropEntity>> getAllActiveCrops(final long userId) {
    final String _sql = "SELECT * FROM crops WHERE isActive = 1 AND userId = ? ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"crops"}, new Callable<List<CropEntity>>() {
      @Override
      @NonNull
      public List<CropEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfVariety = CursorUtil.getColumnIndexOrThrow(_cursor, "variety");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfHybridType = CursorUtil.getColumnIndexOrThrow(_cursor, "hybridType");
          final int _cursorIndexOfPlotName = CursorUtil.getColumnIndexOrThrow(_cursor, "plotName");
          final int _cursorIndexOfZoneBed = CursorUtil.getColumnIndexOrThrow(_cursor, "zoneBed");
          final int _cursorIndexOfAcreage = CursorUtil.getColumnIndexOrThrow(_cursor, "acreage");
          final int _cursorIndexOfSoilType = CursorUtil.getColumnIndexOrThrow(_cursor, "soilType");
          final int _cursorIndexOfPlantingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "plantingDate");
          final int _cursorIndexOfCropAgeDays = CursorUtil.getColumnIndexOrThrow(_cursor, "cropAgeDays");
          final int _cursorIndexOfCurrentStageIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStageIndex");
          final int _cursorIndexOfStageName = CursorUtil.getColumnIndexOrThrow(_cursor, "stageName");
          final int _cursorIndexOfStageCompletionPct = CursorUtil.getColumnIndexOrThrow(_cursor, "stageCompletionPct");
          final int _cursorIndexOfHealthScore = CursorUtil.getColumnIndexOrThrow(_cursor, "healthScore");
          final int _cursorIndexOfHealthStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "healthStatus");
          final int _cursorIndexOfCycleProgressPct = CursorUtil.getColumnIndexOrThrow(_cursor, "cycleProgressPct");
          final int _cursorIndexOfWaterStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "waterStatus");
          final int _cursorIndexOfFertilizerStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fertilizerStatus");
          final int _cursorIndexOfHarvestCountdownDays = CursorUtil.getColumnIndexOrThrow(_cursor, "harvestCountdownDays");
          final int _cursorIndexOfImageResName = CursorUtil.getColumnIndexOrThrow(_cursor, "imageResName");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCertificateId = CursorUtil.getColumnIndexOrThrow(_cursor, "certificateId");
          final int _cursorIndexOfEstimatedYieldTonPerAcre = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedYieldTonPerAcre");
          final int _cursorIndexOfTotalInvestment = CursorUtil.getColumnIndexOrThrow(_cursor, "totalInvestment");
          final int _cursorIndexOfProjectedRevenue = CursorUtil.getColumnIndexOrThrow(_cursor, "projectedRevenue");
          final int _cursorIndexOfSoilMoisturePct = CursorUtil.getColumnIndexOrThrow(_cursor, "soilMoisturePct");
          final List<CropEntity> _result = new ArrayList<CropEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CropEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpVariety;
            _tmpVariety = _cursor.getString(_cursorIndexOfVariety);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final String _tmpHybridType;
            _tmpHybridType = _cursor.getString(_cursorIndexOfHybridType);
            final String _tmpPlotName;
            _tmpPlotName = _cursor.getString(_cursorIndexOfPlotName);
            final String _tmpZoneBed;
            _tmpZoneBed = _cursor.getString(_cursorIndexOfZoneBed);
            final double _tmpAcreage;
            _tmpAcreage = _cursor.getDouble(_cursorIndexOfAcreage);
            final String _tmpSoilType;
            _tmpSoilType = _cursor.getString(_cursorIndexOfSoilType);
            final String _tmpPlantingDate;
            _tmpPlantingDate = _cursor.getString(_cursorIndexOfPlantingDate);
            final int _tmpCropAgeDays;
            _tmpCropAgeDays = _cursor.getInt(_cursorIndexOfCropAgeDays);
            final int _tmpCurrentStageIndex;
            _tmpCurrentStageIndex = _cursor.getInt(_cursorIndexOfCurrentStageIndex);
            final String _tmpStageName;
            _tmpStageName = _cursor.getString(_cursorIndexOfStageName);
            final int _tmpStageCompletionPct;
            _tmpStageCompletionPct = _cursor.getInt(_cursorIndexOfStageCompletionPct);
            final int _tmpHealthScore;
            _tmpHealthScore = _cursor.getInt(_cursorIndexOfHealthScore);
            final String _tmpHealthStatus;
            _tmpHealthStatus = _cursor.getString(_cursorIndexOfHealthStatus);
            final int _tmpCycleProgressPct;
            _tmpCycleProgressPct = _cursor.getInt(_cursorIndexOfCycleProgressPct);
            final String _tmpWaterStatus;
            _tmpWaterStatus = _cursor.getString(_cursorIndexOfWaterStatus);
            final String _tmpFertilizerStatus;
            _tmpFertilizerStatus = _cursor.getString(_cursorIndexOfFertilizerStatus);
            final int _tmpHarvestCountdownDays;
            _tmpHarvestCountdownDays = _cursor.getInt(_cursorIndexOfHarvestCountdownDays);
            final String _tmpImageResName;
            _tmpImageResName = _cursor.getString(_cursorIndexOfImageResName);
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final String _tmpCertificateId;
            _tmpCertificateId = _cursor.getString(_cursorIndexOfCertificateId);
            final double _tmpEstimatedYieldTonPerAcre;
            _tmpEstimatedYieldTonPerAcre = _cursor.getDouble(_cursorIndexOfEstimatedYieldTonPerAcre);
            final double _tmpTotalInvestment;
            _tmpTotalInvestment = _cursor.getDouble(_cursorIndexOfTotalInvestment);
            final double _tmpProjectedRevenue;
            _tmpProjectedRevenue = _cursor.getDouble(_cursorIndexOfProjectedRevenue);
            final int _tmpSoilMoisturePct;
            _tmpSoilMoisturePct = _cursor.getInt(_cursorIndexOfSoilMoisturePct);
            _item = new CropEntity(_tmpId,_tmpUserId,_tmpName,_tmpVariety,_tmpScientificName,_tmpHybridType,_tmpPlotName,_tmpZoneBed,_tmpAcreage,_tmpSoilType,_tmpPlantingDate,_tmpCropAgeDays,_tmpCurrentStageIndex,_tmpStageName,_tmpStageCompletionPct,_tmpHealthScore,_tmpHealthStatus,_tmpCycleProgressPct,_tmpWaterStatus,_tmpFertilizerStatus,_tmpHarvestCountdownDays,_tmpImageResName,_tmpImageUri,_tmpIsActive,_tmpCertificateId,_tmpEstimatedYieldTonPerAcre,_tmpTotalInvestment,_tmpProjectedRevenue,_tmpSoilMoisturePct);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<CropEntity> getCropById(final long id, final long userId) {
    final String _sql = "SELECT * FROM crops WHERE id = ? AND userId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, userId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"crops"}, new Callable<CropEntity>() {
      @Override
      @Nullable
      public CropEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfVariety = CursorUtil.getColumnIndexOrThrow(_cursor, "variety");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfHybridType = CursorUtil.getColumnIndexOrThrow(_cursor, "hybridType");
          final int _cursorIndexOfPlotName = CursorUtil.getColumnIndexOrThrow(_cursor, "plotName");
          final int _cursorIndexOfZoneBed = CursorUtil.getColumnIndexOrThrow(_cursor, "zoneBed");
          final int _cursorIndexOfAcreage = CursorUtil.getColumnIndexOrThrow(_cursor, "acreage");
          final int _cursorIndexOfSoilType = CursorUtil.getColumnIndexOrThrow(_cursor, "soilType");
          final int _cursorIndexOfPlantingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "plantingDate");
          final int _cursorIndexOfCropAgeDays = CursorUtil.getColumnIndexOrThrow(_cursor, "cropAgeDays");
          final int _cursorIndexOfCurrentStageIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStageIndex");
          final int _cursorIndexOfStageName = CursorUtil.getColumnIndexOrThrow(_cursor, "stageName");
          final int _cursorIndexOfStageCompletionPct = CursorUtil.getColumnIndexOrThrow(_cursor, "stageCompletionPct");
          final int _cursorIndexOfHealthScore = CursorUtil.getColumnIndexOrThrow(_cursor, "healthScore");
          final int _cursorIndexOfHealthStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "healthStatus");
          final int _cursorIndexOfCycleProgressPct = CursorUtil.getColumnIndexOrThrow(_cursor, "cycleProgressPct");
          final int _cursorIndexOfWaterStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "waterStatus");
          final int _cursorIndexOfFertilizerStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fertilizerStatus");
          final int _cursorIndexOfHarvestCountdownDays = CursorUtil.getColumnIndexOrThrow(_cursor, "harvestCountdownDays");
          final int _cursorIndexOfImageResName = CursorUtil.getColumnIndexOrThrow(_cursor, "imageResName");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCertificateId = CursorUtil.getColumnIndexOrThrow(_cursor, "certificateId");
          final int _cursorIndexOfEstimatedYieldTonPerAcre = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedYieldTonPerAcre");
          final int _cursorIndexOfTotalInvestment = CursorUtil.getColumnIndexOrThrow(_cursor, "totalInvestment");
          final int _cursorIndexOfProjectedRevenue = CursorUtil.getColumnIndexOrThrow(_cursor, "projectedRevenue");
          final int _cursorIndexOfSoilMoisturePct = CursorUtil.getColumnIndexOrThrow(_cursor, "soilMoisturePct");
          final CropEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpVariety;
            _tmpVariety = _cursor.getString(_cursorIndexOfVariety);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final String _tmpHybridType;
            _tmpHybridType = _cursor.getString(_cursorIndexOfHybridType);
            final String _tmpPlotName;
            _tmpPlotName = _cursor.getString(_cursorIndexOfPlotName);
            final String _tmpZoneBed;
            _tmpZoneBed = _cursor.getString(_cursorIndexOfZoneBed);
            final double _tmpAcreage;
            _tmpAcreage = _cursor.getDouble(_cursorIndexOfAcreage);
            final String _tmpSoilType;
            _tmpSoilType = _cursor.getString(_cursorIndexOfSoilType);
            final String _tmpPlantingDate;
            _tmpPlantingDate = _cursor.getString(_cursorIndexOfPlantingDate);
            final int _tmpCropAgeDays;
            _tmpCropAgeDays = _cursor.getInt(_cursorIndexOfCropAgeDays);
            final int _tmpCurrentStageIndex;
            _tmpCurrentStageIndex = _cursor.getInt(_cursorIndexOfCurrentStageIndex);
            final String _tmpStageName;
            _tmpStageName = _cursor.getString(_cursorIndexOfStageName);
            final int _tmpStageCompletionPct;
            _tmpStageCompletionPct = _cursor.getInt(_cursorIndexOfStageCompletionPct);
            final int _tmpHealthScore;
            _tmpHealthScore = _cursor.getInt(_cursorIndexOfHealthScore);
            final String _tmpHealthStatus;
            _tmpHealthStatus = _cursor.getString(_cursorIndexOfHealthStatus);
            final int _tmpCycleProgressPct;
            _tmpCycleProgressPct = _cursor.getInt(_cursorIndexOfCycleProgressPct);
            final String _tmpWaterStatus;
            _tmpWaterStatus = _cursor.getString(_cursorIndexOfWaterStatus);
            final String _tmpFertilizerStatus;
            _tmpFertilizerStatus = _cursor.getString(_cursorIndexOfFertilizerStatus);
            final int _tmpHarvestCountdownDays;
            _tmpHarvestCountdownDays = _cursor.getInt(_cursorIndexOfHarvestCountdownDays);
            final String _tmpImageResName;
            _tmpImageResName = _cursor.getString(_cursorIndexOfImageResName);
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final String _tmpCertificateId;
            _tmpCertificateId = _cursor.getString(_cursorIndexOfCertificateId);
            final double _tmpEstimatedYieldTonPerAcre;
            _tmpEstimatedYieldTonPerAcre = _cursor.getDouble(_cursorIndexOfEstimatedYieldTonPerAcre);
            final double _tmpTotalInvestment;
            _tmpTotalInvestment = _cursor.getDouble(_cursorIndexOfTotalInvestment);
            final double _tmpProjectedRevenue;
            _tmpProjectedRevenue = _cursor.getDouble(_cursorIndexOfProjectedRevenue);
            final int _tmpSoilMoisturePct;
            _tmpSoilMoisturePct = _cursor.getInt(_cursorIndexOfSoilMoisturePct);
            _result = new CropEntity(_tmpId,_tmpUserId,_tmpName,_tmpVariety,_tmpScientificName,_tmpHybridType,_tmpPlotName,_tmpZoneBed,_tmpAcreage,_tmpSoilType,_tmpPlantingDate,_tmpCropAgeDays,_tmpCurrentStageIndex,_tmpStageName,_tmpStageCompletionPct,_tmpHealthScore,_tmpHealthStatus,_tmpCycleProgressPct,_tmpWaterStatus,_tmpFertilizerStatus,_tmpHarvestCountdownDays,_tmpImageResName,_tmpImageUri,_tmpIsActive,_tmpCertificateId,_tmpEstimatedYieldTonPerAcre,_tmpTotalInvestment,_tmpProjectedRevenue,_tmpSoilMoisturePct);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getCropByIdDirect(final long id, final long userId,
      final Continuation<? super CropEntity> $completion) {
    final String _sql = "SELECT * FROM crops WHERE id = ? AND userId = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CropEntity>() {
      @Override
      @Nullable
      public CropEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfVariety = CursorUtil.getColumnIndexOrThrow(_cursor, "variety");
          final int _cursorIndexOfScientificName = CursorUtil.getColumnIndexOrThrow(_cursor, "scientificName");
          final int _cursorIndexOfHybridType = CursorUtil.getColumnIndexOrThrow(_cursor, "hybridType");
          final int _cursorIndexOfPlotName = CursorUtil.getColumnIndexOrThrow(_cursor, "plotName");
          final int _cursorIndexOfZoneBed = CursorUtil.getColumnIndexOrThrow(_cursor, "zoneBed");
          final int _cursorIndexOfAcreage = CursorUtil.getColumnIndexOrThrow(_cursor, "acreage");
          final int _cursorIndexOfSoilType = CursorUtil.getColumnIndexOrThrow(_cursor, "soilType");
          final int _cursorIndexOfPlantingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "plantingDate");
          final int _cursorIndexOfCropAgeDays = CursorUtil.getColumnIndexOrThrow(_cursor, "cropAgeDays");
          final int _cursorIndexOfCurrentStageIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "currentStageIndex");
          final int _cursorIndexOfStageName = CursorUtil.getColumnIndexOrThrow(_cursor, "stageName");
          final int _cursorIndexOfStageCompletionPct = CursorUtil.getColumnIndexOrThrow(_cursor, "stageCompletionPct");
          final int _cursorIndexOfHealthScore = CursorUtil.getColumnIndexOrThrow(_cursor, "healthScore");
          final int _cursorIndexOfHealthStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "healthStatus");
          final int _cursorIndexOfCycleProgressPct = CursorUtil.getColumnIndexOrThrow(_cursor, "cycleProgressPct");
          final int _cursorIndexOfWaterStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "waterStatus");
          final int _cursorIndexOfFertilizerStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fertilizerStatus");
          final int _cursorIndexOfHarvestCountdownDays = CursorUtil.getColumnIndexOrThrow(_cursor, "harvestCountdownDays");
          final int _cursorIndexOfImageResName = CursorUtil.getColumnIndexOrThrow(_cursor, "imageResName");
          final int _cursorIndexOfImageUri = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUri");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final int _cursorIndexOfCertificateId = CursorUtil.getColumnIndexOrThrow(_cursor, "certificateId");
          final int _cursorIndexOfEstimatedYieldTonPerAcre = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedYieldTonPerAcre");
          final int _cursorIndexOfTotalInvestment = CursorUtil.getColumnIndexOrThrow(_cursor, "totalInvestment");
          final int _cursorIndexOfProjectedRevenue = CursorUtil.getColumnIndexOrThrow(_cursor, "projectedRevenue");
          final int _cursorIndexOfSoilMoisturePct = CursorUtil.getColumnIndexOrThrow(_cursor, "soilMoisturePct");
          final CropEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpUserId;
            _tmpUserId = _cursor.getLong(_cursorIndexOfUserId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpVariety;
            _tmpVariety = _cursor.getString(_cursorIndexOfVariety);
            final String _tmpScientificName;
            _tmpScientificName = _cursor.getString(_cursorIndexOfScientificName);
            final String _tmpHybridType;
            _tmpHybridType = _cursor.getString(_cursorIndexOfHybridType);
            final String _tmpPlotName;
            _tmpPlotName = _cursor.getString(_cursorIndexOfPlotName);
            final String _tmpZoneBed;
            _tmpZoneBed = _cursor.getString(_cursorIndexOfZoneBed);
            final double _tmpAcreage;
            _tmpAcreage = _cursor.getDouble(_cursorIndexOfAcreage);
            final String _tmpSoilType;
            _tmpSoilType = _cursor.getString(_cursorIndexOfSoilType);
            final String _tmpPlantingDate;
            _tmpPlantingDate = _cursor.getString(_cursorIndexOfPlantingDate);
            final int _tmpCropAgeDays;
            _tmpCropAgeDays = _cursor.getInt(_cursorIndexOfCropAgeDays);
            final int _tmpCurrentStageIndex;
            _tmpCurrentStageIndex = _cursor.getInt(_cursorIndexOfCurrentStageIndex);
            final String _tmpStageName;
            _tmpStageName = _cursor.getString(_cursorIndexOfStageName);
            final int _tmpStageCompletionPct;
            _tmpStageCompletionPct = _cursor.getInt(_cursorIndexOfStageCompletionPct);
            final int _tmpHealthScore;
            _tmpHealthScore = _cursor.getInt(_cursorIndexOfHealthScore);
            final String _tmpHealthStatus;
            _tmpHealthStatus = _cursor.getString(_cursorIndexOfHealthStatus);
            final int _tmpCycleProgressPct;
            _tmpCycleProgressPct = _cursor.getInt(_cursorIndexOfCycleProgressPct);
            final String _tmpWaterStatus;
            _tmpWaterStatus = _cursor.getString(_cursorIndexOfWaterStatus);
            final String _tmpFertilizerStatus;
            _tmpFertilizerStatus = _cursor.getString(_cursorIndexOfFertilizerStatus);
            final int _tmpHarvestCountdownDays;
            _tmpHarvestCountdownDays = _cursor.getInt(_cursorIndexOfHarvestCountdownDays);
            final String _tmpImageResName;
            _tmpImageResName = _cursor.getString(_cursorIndexOfImageResName);
            final String _tmpImageUri;
            if (_cursor.isNull(_cursorIndexOfImageUri)) {
              _tmpImageUri = null;
            } else {
              _tmpImageUri = _cursor.getString(_cursorIndexOfImageUri);
            }
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            final String _tmpCertificateId;
            _tmpCertificateId = _cursor.getString(_cursorIndexOfCertificateId);
            final double _tmpEstimatedYieldTonPerAcre;
            _tmpEstimatedYieldTonPerAcre = _cursor.getDouble(_cursorIndexOfEstimatedYieldTonPerAcre);
            final double _tmpTotalInvestment;
            _tmpTotalInvestment = _cursor.getDouble(_cursorIndexOfTotalInvestment);
            final double _tmpProjectedRevenue;
            _tmpProjectedRevenue = _cursor.getDouble(_cursorIndexOfProjectedRevenue);
            final int _tmpSoilMoisturePct;
            _tmpSoilMoisturePct = _cursor.getInt(_cursorIndexOfSoilMoisturePct);
            _result = new CropEntity(_tmpId,_tmpUserId,_tmpName,_tmpVariety,_tmpScientificName,_tmpHybridType,_tmpPlotName,_tmpZoneBed,_tmpAcreage,_tmpSoilType,_tmpPlantingDate,_tmpCropAgeDays,_tmpCurrentStageIndex,_tmpStageName,_tmpStageCompletionPct,_tmpHealthScore,_tmpHealthStatus,_tmpCycleProgressPct,_tmpWaterStatus,_tmpFertilizerStatus,_tmpHarvestCountdownDays,_tmpImageResName,_tmpImageUri,_tmpIsActive,_tmpCertificateId,_tmpEstimatedYieldTonPerAcre,_tmpTotalInvestment,_tmpProjectedRevenue,_tmpSoilMoisturePct);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
