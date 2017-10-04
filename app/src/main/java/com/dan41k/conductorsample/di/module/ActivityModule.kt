package com.dan41k.conductorsample.di.module

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.dan41k.conductorsample.di.annotation.ForActivity
import dagger.Module
import dagger.Provides

@Module class ActivityModule(private val activity: Activity, private val container: ViewGroup, private val bundle: Bundle?) {

    @Provides @ForActivity fun provideActivityInstance() = activity

    @Provides @ForActivity fun provideRouter() = Conductor.attachRouter(activity, container, bundle)
}