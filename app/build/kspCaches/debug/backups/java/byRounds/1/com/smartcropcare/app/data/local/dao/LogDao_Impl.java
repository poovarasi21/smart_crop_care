package com.smartcropcare.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.smartcropcare.app.data.local.entity.FertilizerLogEntity;
import com.smartcropcare.app.data.local.entity.IrrigationLogEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class LogDao_Impl implements LogDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<IrrigationLogEntity> __insertionAdapterOfIrrigationLogEntity;

  private final EntityInsertionAdapter<FertilizerLogEntity> __insertionAdapterOfFertilizerLogEntity;

  public LogDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIrrigationLogEntity = new EntityInsertionAdapter<IrrigationLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `irrigation_logs` (`id`,`cropId`,`date`,`litersApplied`,`durationMinutes`,`method`,`efficiencyPct`,`soilMoisturePct`,`notes`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final IrrigationLogEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCropId());
        statement.bindString(3, entity.getDate());
        statement.bindLong(4, entity.getLitersApplied());
        statement.bindLong(5, entity.getDurationMinutes());
        statement.bindString(6, entity.getMethod());
        statement.bindLong(7, entity.getEfficiencyPct());
        statement.bindLong(8, entity.getSoilMoisturePct());
        statement.bindString(9, entity.getNotes());
      }
    };
    this.__insertionAdapterOfFertilizerLogEntity = new EntityInsertionAdapter<FertilizerLogEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `fertilizer_logs` (`id`,`cropId`,`date`,`nutrientName`,`dosage`,`applicationMethod`,`adherenceStatus`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FertilizerLogEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCropId());
        statement.bindString(3, entity.getDate());
        statement.bindString(4, entity.getNutrientName());
        statement.bindString(5, entity.getDosage());
        statement.bindString(6, entity.getApplicationMethod());
        statement.bindString(7, entity.getAdherenceStatus());
      }
    };
  }

  @Override
  public Object insertIrrigationLog(final IrrigationLogEntity log,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfIrrigationLogEntity.insertAndReturnId(log);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAllIrrigation(final List<IrrigationLogEntity> logs,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfIrrigationLogEntity.insert(logs);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertFertilizerLog(final FertilizerLogEntity log,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfFertilizerLogEntity.insertAndReturnId(log);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAllFertilizer(final List<FertilizerLogEntity> logs,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFertilizerLogEntity.insert(logs);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<IrrigationLogEntity>> getIrrigationLogs(final long cropId) {
    final String _sql = "SELECT * FROM irrigation_logs WHERE cropId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"irrigation_logs"}, new Callable<List<IrrigationLogEntity>>() {
      @Override
      @NonNull
      public List<IrrigationLogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCropId = CursorUtil.getColumnIndexOrThrow(_cursor, "cropId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfLitersApplied = CursorUtil.getColumnIndexOrThrow(_cursor, "litersApplied");
          final int _cursorIndexOfDurationMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMinutes");
          final int _cursorIndexOfMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "method");
          final int _cursorIndexOfEfficiencyPct = CursorUtil.getColumnIndexOrThrow(_cursor, "efficiencyPct");
          final int _cursorIndexOfSoilMoisturePct = CursorUtil.getColumnIndexOrThrow(_cursor, "soilMoisturePct");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final List<IrrigationLogEntity> _result = new ArrayList<IrrigationLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final IrrigationLogEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCropId;
            _tmpCropId = _cursor.getLong(_cursorIndexOfCropId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final int _tmpLitersApplied;
            _tmpLitersApplied = _cursor.getInt(_cursorIndexOfLitersApplied);
            final int _tmpDurationMinutes;
            _tmpDurationMinutes = _cursor.getInt(_cursorIndexOfDurationMinutes);
            final String _tmpMethod;
            _tmpMethod = _cursor.getString(_cursorIndexOfMethod);
            final int _tmpEfficiencyPct;
            _tmpEfficiencyPct = _cursor.getInt(_cursorIndexOfEfficiencyPct);
            final int _tmpSoilMoisturePct;
            _tmpSoilMoisturePct = _cursor.getInt(_cursorIndexOfSoilMoisturePct);
            final String _tmpNotes;
            _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            _item = new IrrigationLogEntity(_tmpId,_tmpCropId,_tmpDate,_tmpLitersApplied,_tmpDurationMinutes,_tmpMethod,_tmpEfficiencyPct,_tmpSoilMoisturePct,_tmpNotes);
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
  public Object getIrrigationSessionCount(final long cropId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM irrigation_logs WHERE cropId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FertilizerLogEntity>> getFertilizerLogs(final long cropId) {
    final String _sql = "SELECT * FROM fertilizer_logs WHERE cropId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"fertilizer_logs"}, new Callable<List<FertilizerLogEntity>>() {
      @Override
      @NonNull
      public List<FertilizerLogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCropId = CursorUtil.getColumnIndexOrThrow(_cursor, "cropId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfNutrientName = CursorUtil.getColumnIndexOrThrow(_cursor, "nutrientName");
          final int _cursorIndexOfDosage = CursorUtil.getColumnIndexOrThrow(_cursor, "dosage");
          final int _cursorIndexOfApplicationMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "applicationMethod");
          final int _cursorIndexOfAdherenceStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "adherenceStatus");
          final List<FertilizerLogEntity> _result = new ArrayList<FertilizerLogEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FertilizerLogEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCropId;
            _tmpCropId = _cursor.getLong(_cursorIndexOfCropId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpNutrientName;
            _tmpNutrientName = _cursor.getString(_cursorIndexOfNutrientName);
            final String _tmpDosage;
            _tmpDosage = _cursor.getString(_cursorIndexOfDosage);
            final String _tmpApplicationMethod;
            _tmpApplicationMethod = _cursor.getString(_cursorIndexOfApplicationMethod);
            final String _tmpAdherenceStatus;
            _tmpAdherenceStatus = _cursor.getString(_cursorIndexOfAdherenceStatus);
            _item = new FertilizerLogEntity(_tmpId,_tmpCropId,_tmpDate,_tmpNutrientName,_tmpDosage,_tmpApplicationMethod,_tmpAdherenceStatus);
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
  public Object getFertilizerDoseCount(final long cropId,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM fertilizer_logs WHERE cropId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
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
