package fr.edf.nexusone.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import fr.edf.nexusone.NexusOneApplication;
import fr.edf.nexusone.di.module.AppModule;
import fr.edf.nexusone.di.module.MainActivityModule;
import fr.edf.nexusone.di.module.NetworkModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class,
        NetworkModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(NexusOneApplication nexusOneApplication);
}
