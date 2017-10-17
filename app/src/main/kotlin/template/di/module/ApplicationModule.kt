package template.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import template.App
import template.di.scopes.ApplicationContext
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideApplicationContext(): Context = application.applicationContext
}
