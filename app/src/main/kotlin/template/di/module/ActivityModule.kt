package template.di.module

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import dagger.Module
import dagger.Provides
import template.di.scopes.ForActivity

@Module
class ActivityModule(private val activity: Activity, private val container: ViewGroup, private val bundle: Bundle?) {

    @Provides
    @ForActivity
    fun provideActivityInstance() = activity

    @Provides
    @ForActivity
    fun provideRouter() = Conductor.attachRouter(activity, container, bundle)
}