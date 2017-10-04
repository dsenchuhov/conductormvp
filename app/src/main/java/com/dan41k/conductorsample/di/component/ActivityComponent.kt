package com.dan41k.conductorsample.di.component

import android.app.Activity
import com.bluelinelabs.conductor.Router
import com.dan41k.conductorsample.MainActivity
import com.dan41k.conductorsample.SecondActivity
import com.dan41k.conductorsample.di.annotation.ForActivity
import com.dan41k.conductorsample.di.module.ActivityModule
import dagger.Subcomponent

@ForActivity @Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: MainActivity)

    fun inject(activity: SecondActivity)

    fun activity(): Activity

    fun router(): Router
}