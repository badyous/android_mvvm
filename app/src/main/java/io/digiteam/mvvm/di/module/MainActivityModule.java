package io.digiteam.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.digiteam.mvvm.ui.activity.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
