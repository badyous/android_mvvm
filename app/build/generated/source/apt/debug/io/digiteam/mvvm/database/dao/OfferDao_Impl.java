package io.digiteam.mvvm.database.dao;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import io.digiteam.mvvm.database.converter.DateConverter;
import io.digiteam.mvvm.database.entity.Offer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("unchecked")
public class OfferDao_Impl implements OfferDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfOffer;

  public OfferDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOffer = new EntityInsertionAdapter<Offer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Offer`(`id`,`name`,`lastRefresh`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Offer value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final Long _tmp;
        _tmp = DateConverter.toTimestamp(value.getLastRefresh());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
      }
    };
  }

  @Override
  public void save(Offer offer) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfOffer.insert(offer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<Offer> load(String name) {
    final String _sql = "SELECT * FROM Offer WHERE name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    return new ComputableLiveData<Offer>() {
      private Observer _observer;

      @Override
      protected Offer compute() {
        if (_observer == null) {
          _observer = new Observer("Offer") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfLastRefresh = _cursor.getColumnIndexOrThrow("lastRefresh");
          final Offer _result;
          if(_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            _result = new Offer(_tmpId,_tmpName);
            final Date _tmpLastRefresh;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfLastRefresh)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfLastRefresh);
            }
            _tmpLastRefresh = DateConverter.toDate(_tmp);
            _result.setLastRefresh(_tmpLastRefresh);
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
    }.getLiveData();
  }

  @Override
  public Offer hasOffer(String name, Date lastRefreshMax) {
    final String _sql = "SELECT * FROM Offer WHERE name = ? AND lastRefresh > ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    _argIndex = 2;
    final Long _tmp;
    _tmp = DateConverter.toTimestamp(lastRefreshMax);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfLastRefresh = _cursor.getColumnIndexOrThrow("lastRefresh");
      final Offer _result;
      if(_cursor.moveToFirst()) {
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result = new Offer(_tmpId,_tmpName);
        final Date _tmpLastRefresh;
        final Long _tmp_1;
        if (_cursor.isNull(_cursorIndexOfLastRefresh)) {
          _tmp_1 = null;
        } else {
          _tmp_1 = _cursor.getLong(_cursorIndexOfLastRefresh);
        }
        _tmpLastRefresh = DateConverter.toDate(_tmp_1);
        _result.setLastRefresh(_tmpLastRefresh);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
