package io.digiteam.mvvm.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import io.digiteam.mvvm.NexusOneApplication;
import io.digiteam.mvvm.di.module.AppModule;
import io.digiteam.mvvm.di.module.MainActivityModule;
import io.digiteam.mvvm.di.module.NetworkModule;

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
