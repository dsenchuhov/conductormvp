package template.di

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.*

class Injector(private val component: Any) {

    @Throws(RuntimeException::class)
    fun inject(injectableObject: Any) {
        val objectClass = injectableObject.javaClass
        try {
            val injectableMethod = findInjectableMethod(objectClass)
            injectableMethod!!.invoke(component, injectableObject)
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            val detailMessage = "No graph method found to inject " + objectClass.simpleName + ". Check your component"
            val exception = RuntimeException(detailMessage, e)

            throw exception
        } catch (e: NullPointerException) {
            val detailMessage = "No graph method found to inject " + objectClass.simpleName + ". Check your component"
            val exception = RuntimeException(detailMessage, e)

            throw exception
        }
    }

    fun isInjectable(injectableObject: Any): Boolean {
        return try {
            findInjectableMethod(injectableObject.javaClass) != null
        } catch (exception: Exception) {
            false
        }
    }

    @Throws(NoSuchMethodException::class)
    private fun findInjectableMethod(objectClass: Class<out Any>): Method? {
        val cachedMethod = cache[objectClass]
        if (cachedMethod != null) {
            return component.javaClass.getDeclaredMethod(cachedMethod.name, objectClass)
        }
        // Find proper injectable method of component to inject presenter instance
        for (m in component.javaClass.declaredMethods) {
            for (pClass in m.parameterTypes) {
                if (pClass == objectClass) {
                    cache.put(objectClass, m)
                    return m
                }
            }
        }
        return null
    }

    companion object {
        private val cache = HashMap<Class<out Any>, Method>()
    }
}