package fr.edf.nexusone.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fr.edf.nexusone.ui.fragments.OfferFragment;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract OfferFragment contributeOfferFragment();
}
