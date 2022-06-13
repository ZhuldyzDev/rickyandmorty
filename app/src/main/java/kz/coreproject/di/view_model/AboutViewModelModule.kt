package kz.coreproject.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.coreproject.ui.about.AboutViewModel
import kz.coreproject.di.view_model.base.ViewModelKey

@Suppress("unused")
@Module
abstract class AboutViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(viewModel: AboutViewModel): ViewModel

}