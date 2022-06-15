package kz.bcc.school.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.bcc.school.ui.activities.main.MainViewModel
import kz.bcc.school.ui.activities.splash.SplashViewModel
import kz.bcc.school.di.view_model.base.ViewModelKey

@Suppress("unused")
@Module
abstract class ActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindActivitySplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindActivityMainViewModel(viewModel: MainViewModel): ViewModel

}