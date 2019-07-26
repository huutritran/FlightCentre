package com.example.fightcentre.di

import com.example.fightcentre.App
import com.example.fightcentre.di.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        AppModule::class,
        ActivityModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    abstract class Builder : AndroidInjector.Factory<App>
}