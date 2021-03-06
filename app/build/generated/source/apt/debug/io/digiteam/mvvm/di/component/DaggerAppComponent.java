// Generated by Dagger (https://google.github.io/dagger).
package io.digiteam.mvvm.di.component;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.Preconditions;
import io.digiteam.mvvm.NexusOneApplication;
import io.digiteam.mvvm.NexusOneApplication_MembersInjector;
import io.digiteam.mvvm.di.module.MainActivityModule_ContributeMainActivity;
import io.digiteam.mvvm.ui.activity.MainActivity;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerAppComponent implements AppComponent {
  private Provider<MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder>
      mainActivitySubcomponentBuilderProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
      getMapOfClassOfAndProviderOfFactoryOf() {
    return Collections
        .<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>
            singletonMap(MainActivity.class, (Provider) mainActivitySubcomponentBuilderProvider);
  }

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newDispatchingAndroidInjector(
        getMapOfClassOfAndProviderOfFactoryOf());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.mainActivitySubcomponentBuilderProvider =
        new Provider<MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder>() {
          @Override
          public MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder get() {
            return new MainActivitySubcomponentBuilder();
          }
        };
  }

  @Override
  public void inject(NexusOneApplication nexusOneApplication) {
    injectNexusOneApplication(nexusOneApplication);
  }

  private NexusOneApplication injectNexusOneApplication(NexusOneApplication instance) {
    NexusOneApplication_MembersInjector.injectDispatchingAndroidInjector(
        instance, getDispatchingAndroidInjectorOfActivity());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public AppComponent build() {
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class MainActivitySubcomponentBuilder
      extends MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder {
    private MainActivity seedInstance;

    @Override
    public MainActivityModule_ContributeMainActivity.MainActivitySubcomponent build() {
      if (seedInstance == null) {
        throw new IllegalStateException(MainActivity.class.getCanonicalName() + " must be set");
      }
      return new MainActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(MainActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl
      implements MainActivityModule_ContributeMainActivity.MainActivitySubcomponent {
    private MainActivitySubcomponentImpl(MainActivitySubcomponentBuilder builder) {}

    @Override
    public void inject(MainActivity arg0) {}
  }
}
