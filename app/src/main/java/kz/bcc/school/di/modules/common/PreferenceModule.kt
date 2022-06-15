package kz.bcc.school.di.modules.common

import android.app.Application
import dagger.Module
import dagger.Provides
import kz.bcc.school.data.preferences.Preferences
import kz.bcc.school.data.preferences.PreferencesImpl

import javax.inject.Singleton

@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun providePreferences(app: Application): Preferences {
        return PreferencesImpl(app)
    }

}