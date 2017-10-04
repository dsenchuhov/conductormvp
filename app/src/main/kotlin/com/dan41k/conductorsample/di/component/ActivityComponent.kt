package com.dan41k.conductorsample.di.component

import android.app.Activity
import com.bluelinelabs.conductor.Router
import com.dan41k.conductorsample.ui.MainActivity
import com.dan41k.conductorsample.ui.SecondActivity
import com.dan41k.conductorsample.di.scopes.ForActivity
import com.dan41k.conductorsample.di.module.ActivityModule
import com.dan41k.conductorsample.di.module.ControllerModule
import dagger.Subcomponent

@ForActivity @Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun plus(controllerModule: ControllerModule): ControllerComponent

    fun inject(activity: MainActivity)

    fun inject(activity: SecondActivity)

    fun activity(): Activity

    fun router(): Router
}