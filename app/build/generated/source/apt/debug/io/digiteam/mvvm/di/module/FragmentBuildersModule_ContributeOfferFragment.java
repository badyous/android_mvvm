package io.digiteam.mvvm.di.module;

import android.support.v4.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import io.digiteam.mvvm.ui.fragments.OfferFragment;

@Module(
  subcomponents = FragmentBuildersModule_ContributeOfferFragment.OfferFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeOfferFragment {
  private FragmentBuildersModule_ContributeOfferFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(OfferFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      OfferFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface OfferFragmentSubcomponent extends AndroidInjector<OfferFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<OfferFragment> {}
  }
}
