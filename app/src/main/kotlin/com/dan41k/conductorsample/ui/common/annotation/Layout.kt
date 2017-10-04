package com.dan41k.conductorsample.ui.common.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Layout(val layoutRes: Int)