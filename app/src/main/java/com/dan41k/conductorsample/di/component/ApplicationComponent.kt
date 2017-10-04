package com.dan41k.conductorsample.di.component

import android.content.Context
import com.dan41k.conductorsample.App
import com.dan41k.conductorsample.di.annotation.ApplicationContext
import com.dan41k.conductorsample.di.module.ActivityModule
import com.dan41k.conductorsample.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(app: App)

    fun plus(activityModule: ActivityModule): ActivityComponent

    @ApplicationContext fun context(): Context
}