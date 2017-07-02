package njc.budget

import njc.budget.injection.AppInjector
import njc.budget.injection.InjectableApp

class BudgetApp: InjectableApp() {
    override fun onCreate() {
        super.onCreate()
        AppInjector.attachToApp(this)
    }
    override fun inject() {
    }
}