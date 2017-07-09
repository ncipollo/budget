package njc.budget.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import njc.budget.MainActivity

/**
 * Module for defining which activities participate in android injection.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}