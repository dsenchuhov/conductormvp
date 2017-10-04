package com.dan41k.conductorsample.di.module

import android.content.Context
import com.dan41k.conductorsample.App
import com.dan41k.conductorsample.di.scopes.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule(private val application: App) {

    @Provides @Singleton @ApplicationContext fun provideApplicationContext(): Context = application.applicationContext
}
