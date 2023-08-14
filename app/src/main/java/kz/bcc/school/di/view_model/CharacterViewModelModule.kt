package kz.bcc.school.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.bcc.school.di.view_model.base.ViewModelKey
import kz.bcc.school.ui.character.CharacterViewModel
import kz.bcc.school.ui.detail.CharacterDetailViewModel

@Suppress("unused")
@Module
abstract class CharacterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindCharacterViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailViewModel::class)
    abstract fun bindCharacterDetailViewModel(viewModel: CharacterDetailViewModel): ViewModel
}