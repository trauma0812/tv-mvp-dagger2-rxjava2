package jp.co.nino.learning.di.module;

import android.app.Application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import jp.co.nino.learning.data.DataSource;
import jp.co.nino.learning.data.api.ApiUrl;
import jp.co.nino.learning.data.api.RemoteDataSource;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by liu.rui on 2017/12/15.
 */

@Module
abstract public class DataRepositoryModule {

    @Singleton
    @Binds
    abstract DataSource provideDataSource(RemoteDataSource dataSource);

    @Provides
    @Singleton
    static Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    static ObjectMapper provideObjectMapper() {
        return new ObjectMapper();
    }

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.cache();
        return client;
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiUrl.ENDPOINT_BASE_URL)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

}
