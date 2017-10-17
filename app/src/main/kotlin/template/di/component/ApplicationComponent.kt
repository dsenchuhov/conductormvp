package template.di.component

import android.content.Context
import dagger.Component
import template.App
import template.api.Api
import template.di.module.ActivityModule
import template.di.module.ApiModule
import template.di.module.ApplicationModule
import template.di.scopes.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApiModule::class))
interface ApplicationComponent {

    fun inject(app: App)

    fun plus(activityModule: ActivityModule): ActivityComponent

    @ApplicationContext
    fun context(): Context

    fun api(): Api
}