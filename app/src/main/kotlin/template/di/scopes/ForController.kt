package template.di.scopes

import javax.inject.Scope

@Target(AnnotationTarget.CLASS,
        AnnotationTarget.TYPE,
        AnnotationTarget.FIELD,
        AnnotationTarget.FUNCTION,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
@Scope annotation class ForController