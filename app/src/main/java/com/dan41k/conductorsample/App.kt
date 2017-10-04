package com.dan41k.conductorsample

import android.app.Application
import com.dan41k.conductorsample.di.component.ApplicationComponent
import com.dan41k.conductorsample.di.module.ApplicationModule
import com.dan41k.conductorsample.di.component.DaggerApplicationComponent

class App: Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}