package com.dan41k.conductorsample.di.annotation

@Target(AnnotationTarget.TYPE,
        AnnotationTarget.FIELD,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext
