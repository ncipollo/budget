package njc.budget.injection

import android.app.Application

abstract class InjectableApp : Application() {
    abstract fun inject()
}

interface InjectableActivity
interface InjectableFragment