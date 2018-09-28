package fr.edf.nexusone.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.Date;

import fr.edf.nexusone.database.entity.Offer;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;
@Dao
public interface OfferDao {
    @Insert(onConflict = REPLACE)
    void save(Offer offer);

    @Query("SELECT * FROM Offer WHERE name = :name")
    LiveData<Offer> load(String name);

    @Query("SELECT * FROM Offer WHERE name = :name AND lastRefresh > :lastRefreshMax LIMIT 1")
    Offer hasOffer(String name, Date lastRefreshMax);
}
