package kz.bcc.school.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.bcc.school.ui.about.AboutViewModel
import kz.bcc.school.di.view_model.base.ViewModelKey

@Suppress("unused")
@Module
abstract class AboutViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindAboutViewModel(viewModel: AboutViewModel): ViewModel

}