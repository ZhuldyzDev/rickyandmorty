package kz.bcc.school.di.modules.common

import dagger.Module
import dagger.Provides
import kz.bcc.school.data.preferences.Preferences
import kz.bcc.school.network.utils.HeaderUtils
import kz.bcc.school.network.utils.UniqueID
import javax.inject.Singleton

@Module
class UtilsModule {

    @Provides
    @Singleton
    fun provideUniqueID(preferences: Preferences) = UniqueID(preferences)

    @Provides
    @Singleton
    fun provideHeaderUtils(preferences: Preferences, uniqueID: UniqueID) = HeaderUtils(preferences, uniqueID)

}