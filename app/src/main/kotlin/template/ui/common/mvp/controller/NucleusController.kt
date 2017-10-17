package template.ui.common.mvp.controller

import android.os.Bundle
import android.support.annotation.CallSuper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import nucleus5.factory.PresenterFactory
import nucleus5.factory.ReflectionPresenterFactory
import nucleus5.presenter.RxPresenter
import nucleus5.view.PresenterLifecycleDelegate
import nucleus5.view.ViewWithPresenter
import template.di.component.ControllerComponent
import template.di.module.ControllerModule
import template.ui.common.activity.BaseActivity
import template.ui.common.annotation.Layout
import template.ui.common.mvp.DaggerPresenterFactory

abstract class NucleusController<P : RxPresenter<out Any>> : Controller, ViewWithPresenter<P> {

    private val presenterDelegate by lazy {
        PresenterLifecycleDelegate<P>(
                DaggerPresenterFactory<P, ReflectionPresenterFactory<P>>(
                        ReflectionPresenterFactory.fromViewClass<P>(javaClass)!!, screenComponent()
                )
        )
    }

    constructor() : this(null)

    constructor(bundle: Bundle?) : super(bundle)

    private val lifecycleListener = object : Controller.LifecycleListener() {

        override fun postCreateView(controller: Controller, view: View) {
            super.postCreateView(controller, view)

            onViewCreated(view)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(layout(), container, false)

        addLifecycleListener(lifecycleListener)

        return view
    }

    @CallSuper
    open fun onViewCreated(view: View) {
        // here presenter will be created
        presenterDelegate.onResume(this)
    }

    override fun onDestroy() {
        presenterDelegate.onDestroy(true)
        removeLifecycleListener(lifecycleListener)
        super.onDestroy()
    }

    private fun layout(): Int {
        this.javaClass.kotlin.annotations.forEach { if (it is Layout) return it.layoutRes }
        throw IllegalArgumentException("You should specify Layout annotation")
    }

    override fun onDestroyView(view: View) {
        presenterDelegate.onDropView()

        super.onDestroyView(view)
    }

    override fun getPresenter(): P = presenterDelegate.presenter

    override fun getPresenterFactory(): PresenterFactory<P> = presenterDelegate.presenterFactory!!

    override fun setPresenterFactory(presenterFactory: PresenterFactory<P>?) {
        presenterDelegate.presenterFactory = presenterFactory
    }

    private fun screenComponent(): ControllerComponent =
            (activity as BaseActivity).component().plus(ControllerModule(this))
}