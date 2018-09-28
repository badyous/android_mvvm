package fr.edf.nexusone.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import fr.edf.nexusone.database.converter.DateConverter;
import fr.edf.nexusone.database.dao.OfferDao;
import fr.edf.nexusone.database.entity.Offer;

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
