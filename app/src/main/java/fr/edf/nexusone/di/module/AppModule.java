package fr.edf.nexusone.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.edf.nexusone.database.NexusOneDatabase;
import fr.edf.nexusone.database.dao.OfferDao;

import static fr.edf.nexusone.utils.Constants.DATABASE_FILE_NAME;

@Module
public class AppModule {

    @Provides
    @Singleton
    public NexusOneDatabase provideDb(Application application){
        return Room
                .databaseBuilder(application, NexusOneDatabase.class, DATABASE_FILE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public OfferDao provideOfferDao(NexusOneDatabase db) {
        return db.offerDao();
    }
}
