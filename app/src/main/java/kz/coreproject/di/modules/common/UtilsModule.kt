package kz.coreproject.di.modules.common

import dagger.Module
import dagger.Provides
import kz.coreproject.data.preferences.Preferences
import kz.coreproject.network.utils.HeaderUtils
import kz.coreproject.network.utils.UniqueID
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