package com.example.fightcentre.di

import android.content.Context
import com.example.fightcentre.App
import com.example.fightcentre.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app:App):Context = app

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(createOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @IOScheduler
    fun ioScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @MainScheduler
    fun mainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    private fun createOkHttpClient():OkHttpClient{
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG){
            okHttpClientBuilder.addNetworkInterceptor(StethoInterceptor())
                .build()
        }
        return okHttpClientBuilder.build()
    }
}