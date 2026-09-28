package com.smartcropcare.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.smartcropcare.app.data.local.entity.PestRecordEntity;
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
public final class PestDao_Impl implements PestDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PestRecordEntity> __insertionAdapterOfPestRecordEntity;

  private final EntityDeletionOrUpdateAdapter<PestRecordEntity> __deletionAdapterOfPestRecordEntity;

  public PestDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPestRecordEntity = new EntityInsertionAdapter<PestRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `pest_records` (`id`,`cropId`,`date`,`pestName`,`damageSymptoms`,`managementAction`,`treatmentNotes`,`imagePath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PestRecordEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCropId());
        statement.bindString(3, entity.getDate());
        statement.bindString(4, entity.getPestName());
        statement.bindString(5, entity.getDamageSymptoms());
        statement.bindString(6, entity.getManagementAction());
        statement.bindString(7, entity.getTreatmentNotes());
        if (entity.getImagePath() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getImagePath());
        }
      }
    };
    this.__deletionAdapterOfPestRecordEntity = new EntityDeletionOrUpdateAdapter<PestRecordEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `pest_records` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PestRecordEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertPest(final PestRecordEntity pest,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfPestRecordEntity.insertAndReturnId(pest);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePest(final PestRecordEntity pest,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPestRecordEntity.handle(pest);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PestRecordEntity>> getPestsByCropId(final long cropId) {
    final String _sql = "SELECT * FROM pest_records WHERE cropId = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cropId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pest_records"}, new Callable<List<PestRecordEntity>>() {
      @Override
      @NonNull
      public List<PestRecordEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCropId = CursorUtil.getColumnIndexOrThrow(_cursor, "cropId");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfPestName = CursorUtil.getColumnIndexOrThrow(_cursor, "pestName");
          final int _cursorIndexOfDamageSymptoms = CursorUtil.getColumnIndexOrThrow(_cursor, "damageSymptoms");
          final int _cursorIndexOfManagementAction = CursorUtil.getColumnIndexOrThrow(_cursor, "managementAction");
          final int _cursorIndexOfTreatmentNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "treatmentNotes");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final List<PestRecordEntity> _result = new ArrayList<PestRecordEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PestRecordEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCropId;
            _tmpCropId = _cursor.getLong(_cursorIndexOfCropId);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpPestName;
            _tmpPestName = _cursor.getString(_cursorIndexOfPestName);
            final String _tmpDamageSymptoms;
            _tmpDamageSymptoms = _cursor.getString(_cursorIndexOfDamageSymptoms);
            final String _tmpManagementAction;
            _tmpManagementAction = _cursor.getString(_cursorIndexOfManagementAction);
            final String _tmpTreatmentNotes;
            _tmpTreatmentNotes = _cursor.getString(_cursorIndexOfTreatmentNotes);
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            _item = new PestRecordEntity(_tmpId,_tmpCropId,_tmpDate,_tmpPestName,_tmpDamageSymptoms,_tmpManagementAction,_tmpTreatmentNotes,_tmpImagePath);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
