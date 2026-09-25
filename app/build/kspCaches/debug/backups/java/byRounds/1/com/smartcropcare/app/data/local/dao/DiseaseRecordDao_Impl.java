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
import com.smartcropcare.app.data.local.entity.DiseaseRecordEntity;
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
public final class DiseaseRecordDao_Impl implements DiseaseRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DiseaseRecordEntity> __insertionAdapterOfDiseaseRecordEntity;

  public DiseaseRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDiseaseRecordEntity = new EntityInsertionAdapter<DiseaseRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `disease_records` (`id`,`cropId`,`date`,`diseaseName`,`pathogen`,`confidencePct`,`severityStage`,`observedSymptoms`,`organicTreatment`,`chemicalTreatment`,`imagePath`,`status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DiseaseRecordEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCropId());
        statement.bindString(3, entity.getDate());
        statement.bindString(4, entity.getDiseaseName());
        statement.bindString(5, entity.getPathogen());
        statement.bindDouble(6, entity.getConfidencePct());
        statement.bindString(7, entity.getSeverityStage());
        statement.bindString(8, entity.getObservedSymptoms());
        statement.bindString(9, entity.getOrganicTreatment());
        statement.bindString(10, entity.getChemicalTreatment());
        if (entity.getImagePath() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getImagePath());
        }
        statement.bindString(12, entity.getStatus());
      }
    };
  }

  @Override
  public Object insertRecord(final DiseaseRecordEntity record,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDiseaseRecordEntity.insertAndReturnId(record);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<DiseaseRecordEntity> records,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDiseaseRecordEntity.insert(records);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<DiseaseRecordEntity>> getRecordsByCropId(final long cropId) {
    final String _sql = "SELECT * FROM disease_records WHERE cropId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"disease_records"}, new Callable<List<DiseaseRecordEntity>>() {
      @Override
      @NonNull
      public List<DiseaseRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCropId = CursorUtil.getColumnIndexOrThrow(_cursor, "cropId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfDiseaseName = CursorUtil.getColumnIndexOrThrow(_cursor, "diseaseName");
          final int _cursorIndexOfPathogen = CursorUtil.getColumnIndexOrThrow(_cursor, "pathogen");
          final int _cursorIndexOfConfidencePct = CursorUtil.getColumnIndexOrThrow(_cursor, "confidencePct");
          final int _cursorIndexOfSeverityStage = CursorUtil.getColumnIndexOrThrow(_cursor, "severityStage");
          final int _cursorIndexOfObservedSymptoms = CursorUtil.getColumnIndexOrThrow(_cursor, "observedSymptoms");
          final int _cursorIndexOfOrganicTreatment = CursorUtil.getColumnIndexOrThrow(_cursor, "organicTreatment");
          final int _cursorIndexOfChemicalTreatment = CursorUtil.getColumnIndexOrThrow(_cursor, "chemicalTreatment");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final List<DiseaseRecordEntity> _result = new ArrayList<DiseaseRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DiseaseRecordEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCropId;
            _tmpCropId = _cursor.getLong(_cursorIndexOfCropId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpDiseaseName;
            _tmpDiseaseName = _cursor.getString(_cursorIndexOfDiseaseName);
            final String _tmpPathogen;
            _tmpPathogen = _cursor.getString(_cursorIndexOfPathogen);
            final double _tmpConfidencePct;
            _tmpConfidencePct = _cursor.getDouble(_cursorIndexOfConfidencePct);
            final String _tmpSeverityStage;
            _tmpSeverityStage = _cursor.getString(_cursorIndexOfSeverityStage);
            final String _tmpObservedSymptoms;
            _tmpObservedSymptoms = _cursor.getString(_cursorIndexOfObservedSymptoms);
            final String _tmpOrganicTreatment;
            _tmpOrganicTreatment = _cursor.getString(_cursorIndexOfOrganicTreatment);
            final String _tmpChemicalTreatment;
            _tmpChemicalTreatment = _cursor.getString(_cursorIndexOfChemicalTreatment);
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            _item = new DiseaseRecordEntity(_tmpId,_tmpCropId,_tmpDate,_tmpDiseaseName,_tmpPathogen,_tmpConfidencePct,_tmpSeverityStage,_tmpObservedSymptoms,_tmpOrganicTreatment,_tmpChemicalTreatment,_tmpImagePath,_tmpStatus);
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
  public Object getScanCount(final long cropId, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM disease_records WHERE cropId = ?";
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
