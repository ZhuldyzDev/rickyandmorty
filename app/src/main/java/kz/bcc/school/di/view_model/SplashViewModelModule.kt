package kz.bcc.school.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.bcc.school.ui.splash.SplashViewModel
import kz.bcc.school.di.view_model.base.ViewModelKey

@Suppress("unused")
@Module
abstract class SplashViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

}