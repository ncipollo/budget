package njc.budget.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import njc.budget.BudgetApp
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ActivityModule::class, AndroidSupportInjectionModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun inject(app: BudgetApp)
}