package template.di.component

import dagger.Subcomponent
import template.di.module.ControllerModule
import template.di.scopes.ForController
import template.ui.detail.DetailPresenter
import template.ui.main.MainPresenter

@ForController
@Subcomponent(modules = arrayOf(ControllerModule::class))
interface ControllerComponent {

    fun inject(presenter: MainPresenter)

    fun inject(presenter: DetailPresenter)
}