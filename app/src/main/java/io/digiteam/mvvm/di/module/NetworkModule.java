package io.digiteam.mvvm.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.digiteam.mvvm.network.NetworkApiService;
import io.digiteam.mvvm.repository.util.LiveDataCallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.digiteam.mvvm.utils.Constants.BASE_URL;
import static io.digiteam.mvvm.utils.Constants.TIMEOUT_IN_SEC;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    NetworkApiService provideNetworkApi(Retrofit retrofit){
        return retrofit.create(NetworkApiService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.readTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(TIMEOUT_IN_SEC, TimeUnit.SECONDS);
        //TODO add interceptor okHttpClient.addInterceptor();
        return okHttpClient.build();
    }
}
