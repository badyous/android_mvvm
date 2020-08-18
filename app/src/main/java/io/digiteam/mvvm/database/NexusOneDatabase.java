package io.digiteam.mvvm.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import io.digiteam.mvvm.database.converter.DateConverter;
import io.digiteam.mvvm.database.dao.OfferDao;
import io.digiteam.mvvm.database.entity.Offer;

@Database(
        entities = {Offer.class},
        version = 1)
@TypeConverters(DateConverter.class)
public abstract class NexusOneDatabase extends RoomDatabase{
    // --- SINGLETON ---
    private static volatile NexusOneDatabase INSTANCE;

    // --- DAO ---
    public abstract OfferDao offerDao();

}
