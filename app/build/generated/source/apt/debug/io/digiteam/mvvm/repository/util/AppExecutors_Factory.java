// Generated by Dagger (https://google.github.io/dagger).
package io.digiteam.mvvm.repository.util;

import dagger.internal.Factory;

public final class AppExecutors_Factory implements Factory<AppExecutors> {
  private static final AppExecutors_Factory INSTANCE = new AppExecutors_Factory();

  @Override
  public AppExecutors get() {
    return new AppExecutors();
  }

  public static AppExecutors_Factory create() {
    return INSTANCE;
  }
}