package com.dan41k.conductorsample.di.component

import com.dan41k.conductorsample.di.module.ControllerModule
import com.dan41k.conductorsample.di.scopes.ForController
import com.dan41k.conductorsample.ui.detail.DetailPresenter
import com.dan41k.conductorsample.ui.main.MainPresenter
import dagger.Subcomponent

@ForController
@Subcomponent(modules = arrayOf(ControllerModule::class))
interface ControllerComponent {

    fun inject(presenter: MainPresenter)

    fun inject(presenter: DetailPresenter)
}