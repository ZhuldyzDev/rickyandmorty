package kz.test.rickandmorty.di.view_model

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kz.test.rickandmorty.di.view_model.base.ViewModelKey
import kz.test.rickandmorty.ui.character.CharacterViewModel

@Suppress("unused")
@Module
abstract class CharacterViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CharacterViewModel::class)
    abstract fun bindCharacterViewModel(viewModel: CharacterViewModel): ViewModel
}