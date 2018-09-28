package fr.edf.nexusone.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fr.edf.nexusone.ui.activity.MainActivity;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
