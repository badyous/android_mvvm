package io.digiteam.mvvm.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import io.digiteam.mvvm.database.dao.OfferDao;
import io.digiteam.mvvm.database.dao.OfferDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class NexusOneDatabase_Impl extends NexusOneDatabase {
  private volatile OfferDao _offerDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Offer` (`id` TEXT NOT NULL, `name` TEXT, `lastRefresh` INTEGER, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"8b50f236d622a8ade0d40cc603b5d4ad\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Offer`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsOffer = new HashMap<String, TableInfo.Column>(3);
        _columnsOffer.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsOffer.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsOffer.put("lastRefresh", new TableInfo.Column("lastRefresh", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOffer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOffer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOffer = new TableInfo("Offer", _columnsOffer, _foreignKeysOffer, _indicesOffer);
        final TableInfo _existingOffer = TableInfo.read(_db, "Offer");
        if (! _infoOffer.equals(_existingOffer)) {
          throw new IllegalStateException("Migration didn't properly handle Offer(io.digiteam.mvvm.database.entity.Offer).\n"
                  + " Expected:\n" + _infoOffer + "\n"
                  + " Found:\n" + _existingOffer);
        }
      }
    }, "8b50f236d622a8ade0d40cc603b5d4ad", "f5cd95be4d320bbbbc9759a785f3d40f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Offer");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Offer`");
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
  public OfferDao offerDao() {
    if (_offerDao != null) {
      return _offerDao;
    } else {
      synchronized(this) {
        if(_offerDao == null) {
          _offerDao = new OfferDao_Impl(this);
        }
        return _offerDao;
      }
    }
  }
}
