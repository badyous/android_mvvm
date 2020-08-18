package io.digiteam.mvvm.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import io.digiteam.mvvm.di.qualifiers.ViewModelKey;
import io.digiteam.mvvm.viewmodel.NexusOneViewModelFactory;
import io.digiteam.mvvm.viewmodel.OffersViewModel;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(OffersViewModel.class)
    abstract ViewModel bindOffersViewModel(OffersViewModel offersViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(NexusOneViewModelFactory nexusOneViewModelFactory);
}
