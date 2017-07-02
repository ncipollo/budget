package njc.budget.injection

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {
    fun attachToApp(app: InjectableApp) {
        app.inject()
        observeActivityLifecycle(app)
    }

    private fun handleActivity(activity: FragmentActivity) {
        AndroidInjection.inject(activity)
        observeFragmentLifecycle(activity)
    }

    private fun handleFragment(fragment: Fragment) {
        AndroidSupportInjection.inject(fragment)
    }

    private fun observeActivityLifecycle(app: InjectableApp) {
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) = Unit
            override fun onActivityResumed(activity: Activity) = Unit
            override fun onActivityStarted(activity: Activity) = Unit
            override fun onActivityDestroyed(activity: Activity) = Unit
            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) = Unit
            override fun onActivityStopped(activity: Activity) = Unit

            override fun onActivityCreated(activity: Activity, p1: Bundle?) {
                if (activity !is FragmentActivity) {
                    throw IllegalStateException("Non-compat activity created: $activity")
                }
                if (activity is HasSupportFragmentInjector) {
                    handleActivity(activity)
                }
            }
        })
    }

    private fun observeFragmentLifecycle(activity: FragmentActivity) {
        val callbacks = object : FragmentManager.FragmentLifecycleCallbacks() {
            override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
                if (f is InjectableFragment) {
                    handleFragment(f)
                }
            }
        }
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(callbacks, true)
    }
}