package com.dan41k.conductorsample.di.component

import com.dan41k.conductorsample.di.module.ControllerModule
import com.dan41k.conductorsample.di.scopes.ForController
import dagger.Subcomponent

@ForController
@Subcomponent(modules = arrayOf(ControllerModule::class))
interface ControllerComponent {


}