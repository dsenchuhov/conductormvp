package com.dan41k.conductorsample.di.annotation

import javax.inject.Scope

@Target(AnnotationTarget.CLASS,
        AnnotationTarget.TYPE,
        AnnotationTarget.FIELD,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE) @Scope annotation class ForController