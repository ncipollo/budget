package njc.budget

import android.app.Activity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import njc.budget.injection.AppInjector
import njc.budget.injection.DaggerAppComponent
import njc.budget.injection.InjectableApp
import javax.inject.Inject

class BudgetApp : HasActivityInjector, InjectableApp() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.attachToApp(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun inject() = DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
}