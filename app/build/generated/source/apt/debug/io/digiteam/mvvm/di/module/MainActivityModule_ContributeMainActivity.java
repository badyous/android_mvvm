package io.digiteam.mvvm.di.module;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import io.digiteam.mvvm.ui.activity.MainActivity;

@Module(subcomponents = MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.class)
public abstract class MainActivityModule_ContributeMainActivity {
  private MainActivityModule_ContributeMainActivity() {}

  @Binds
  @IntoMap
  @ActivityKey(MainActivity.class)
  abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Builder builder);

  @Subcomponent(modules = FragmentBuildersModule.class)
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
  }
}
