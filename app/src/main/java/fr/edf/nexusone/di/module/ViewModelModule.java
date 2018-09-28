package fr.edf.nexusone.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import fr.edf.nexusone.di.qualifiers.ViewModelKey;
import fr.edf.nexusone.viewmodel.NexusOneViewModelFactory;
import fr.edf.nexusone.viewmodel.OffersViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(OffersViewModel.class)
    abstract ViewModel bindOffersViewModel(OffersViewModel offersViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(NexusOneViewModelFactory nexusOneViewModelFactory);
}
