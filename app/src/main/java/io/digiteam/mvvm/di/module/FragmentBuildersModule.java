package io.digiteam.mvvm.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.digiteam.mvvm.ui.fragments.OfferFragment;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract OfferFragment contributeOfferFragment();
}
