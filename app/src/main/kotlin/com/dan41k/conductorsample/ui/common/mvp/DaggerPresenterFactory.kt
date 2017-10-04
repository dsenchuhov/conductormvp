package com.dan41k.conductorsample.ui.common.mvp

import android.util.Log
import com.dan41k.conductorsample.di.Injector
import nucleus.factory.PresenterFactory
import nucleus.presenter.Presenter

class DaggerPresenterFactory<P : Presenter<out Any>,
        out PF : PresenterFactory<P>>(private val presenterFactory: PF,
                                      component: Any) : PresenterFactory<P> {

    private val injector: Injector = Injector(component)

    override fun createPresenter(): P {
        val presenter = presenterFactory.createPresenter()

        try {
            if (injector.isInjectable(presenter)) injector.inject(presenter)
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message)
        }

        return presenter
    }
}