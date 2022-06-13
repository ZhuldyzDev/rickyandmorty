package kz.coreproject.utils.locale

import android.content.Context
import android.content.res.Configuration
import kz.coreproject.data.enums.api.LanguageEnums
import kz.coreproject.data.preferences.PreferencesImpl
import java.util.*

//http://developine.com/android-app-language-change-localization-programatically-kotlin-example/
object LocaleUtils {

    fun setLocale(context: Context?): Context? {
        return if (context != null) {
            val preferences = PreferencesImpl(context)

            if (preferences.getLanguage() != null) {
                updateResources(context, preferences.getLanguage()!!)
            } else {
                context
            }

        } else {
            context
        }
    }

    fun setNewLocale(context: Context, language: String) {
        updateResources(context, language)
    }

    private fun updateResources(context: Context, language: String): Context {

        val locale = Locale(getSystemLanguage(language))
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = Configuration(resources.configuration)

        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }

    private fun getSystemLanguage(language: String): String {
        return when (language) {
            LanguageEnums.KZ.apiId -> {
                LanguageEnums.KZ.systemId
            }
            LanguageEnums.RU.apiId -> {
                LanguageEnums.RU.systemId
            }
            else -> {
                LanguageEnums.DEFAULT.systemId
            }
        }
    }

}