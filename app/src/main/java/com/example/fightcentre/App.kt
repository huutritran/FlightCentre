package com.example.fightcentre

import com.example.fightcentre.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector() = DaggerAppComponent.factory().create(this)

}