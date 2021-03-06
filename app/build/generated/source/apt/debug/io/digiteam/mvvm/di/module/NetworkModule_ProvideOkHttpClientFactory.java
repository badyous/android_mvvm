// Generated by Dagger (https://google.github.io/dagger).
package io.digiteam.mvvm.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  public NetworkModule_ProvideOkHttpClientFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return Preconditions.checkNotNull(
        module.provideOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(NetworkModule module) {
    return new NetworkModule_ProvideOkHttpClientFactory(module);
  }

  public static OkHttpClient proxyProvideOkHttpClient(NetworkModule instance) {
    return Preconditions.checkNotNull(
        instance.provideOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
