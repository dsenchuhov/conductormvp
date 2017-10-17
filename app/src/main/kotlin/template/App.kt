package template

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import template.di.component.ApplicationComponent
import template.di.component.DaggerApplicationComponent
import template.di.module.ApplicationModule
import timber.log.Timber

class App : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        timber()
    }

    private fun timber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                @SuppressLint("DefaultLocale")
                override fun createStackElementTag(element: StackTraceElement): String {
                    return String.format("@@ %s.%s:%d thread[%s]",
                            super.createStackElementTag(element),
                            element.methodName, element.lineNumber, Thread.currentThread().name)
                }
            })
        } else {
            Timber.plant(object : Timber.Tree() {
                override fun log(priority: Int, tag: String, message: String, throwable: Throwable?) {
                    if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                        return
                    }
                    //CrashLibrary.log(priority, tag, message)
                }
            })
        }
    }
}