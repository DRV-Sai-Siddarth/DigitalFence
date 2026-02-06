package eu.tutorials.DailyDoserApp.data;

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
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MedicineDao_Impl implements MedicineDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MedicineEntity> __insertionAdapterOfMedicineEntity;

  private final EntityDeletionOrUpdateAdapter<MedicineEntity> __deletionAdapterOfMedicineEntity;

  private final EntityDeletionOrUpdateAdapter<MedicineEntity> __updateAdapterOfMedicineEntity;

  public MedicineDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMedicineEntity = new EntityInsertionAdapter<MedicineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `medicines` (`id`,`medicine_name`,`remaining_doses`,`is_taken_today`,`added_on`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicineEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getDoses());
        final int _tmp = entity.isTaken() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.getAddedDate());
      }
    };
    this.__deletionAdapterOfMedicineEntity = new EntityDeletionOrUpdateAdapter<MedicineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `medicines` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicineEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfMedicineEntity = new EntityDeletionOrUpdateAdapter<MedicineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `medicines` SET `id` = ?,`medicine_name` = ?,`remaining_doses` = ?,`is_taken_today` = ?,`added_on` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MedicineEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getDoses());
        final int _tmp = entity.isTaken() ? 1 : 0;
        statement.bindLong(4, _tmp);
        statement.bindLong(5, entity.getAddedDate());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public Object addMedicine(final MedicineEntity medicine,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMedicineEntity.insert(medicine);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMedicine(final MedicineEntity medicine,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMedicineEntity.handle(medicine);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateMedicine(final MedicineEntity medicine,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMedicineEntity.handle(medicine);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<MedicineEntity>> getAllMedicines() {
    final String _sql = "SELECT * FROM medicines ORDER BY is_taken_today ASC, medicine_name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"medicines"}, new Callable<List<MedicineEntity>>() {
      @Override
      @NonNull
      public List<MedicineEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "medicine_name");
          final int _cursorIndexOfDoses = CursorUtil.getColumnIndexOrThrow(_cursor, "remaining_doses");
          final int _cursorIndexOfIsTaken = CursorUtil.getColumnIndexOrThrow(_cursor, "is_taken_today");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_on");
          final List<MedicineEntity> _result = new ArrayList<MedicineEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MedicineEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpDoses;
            _tmpDoses = _cursor.getInt(_cursorIndexOfDoses);
            final boolean _tmpIsTaken;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTaken);
            _tmpIsTaken = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            _item = new MedicineEntity(_tmpId,_tmpName,_tmpDoses,_tmpIsTaken,_tmpAddedDate);
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
  public Flow<MedicineEntity> getMedicineById(final long id) {
    final String _sql = "SELECT * FROM medicines WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"medicines"}, new Callable<MedicineEntity>() {
      @Override
      @NonNull
      public MedicineEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "medicine_name");
          final int _cursorIndexOfDoses = CursorUtil.getColumnIndexOrThrow(_cursor, "remaining_doses");
          final int _cursorIndexOfIsTaken = CursorUtil.getColumnIndexOrThrow(_cursor, "is_taken_today");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "added_on");
          final MedicineEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpDoses;
            _tmpDoses = _cursor.getInt(_cursorIndexOfDoses);
            final boolean _tmpIsTaken;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsTaken);
            _tmpIsTaken = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            _result = new MedicineEntity(_tmpId,_tmpName,_tmpDoses,_tmpIsTaken,_tmpAddedDate);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
