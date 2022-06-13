package kz.coreproject.di.modules.common

import android.app.Application
import dagger.Module
import dagger.Provides
import kz.coreproject.data.preferences.Preferences
import kz.coreproject.data.preferences.PreferencesImpl

import javax.inject.Singleton

@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun providePreferences(app: Application): Preferences {
        return PreferencesImpl(app)
    }

}