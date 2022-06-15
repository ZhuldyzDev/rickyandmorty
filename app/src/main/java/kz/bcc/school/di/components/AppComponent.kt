package kz.bcc.school.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kz.bcc.school.App
import kz.bcc.school.di.contributes_android_injector.activity.ActivityBuildersModule
import kz.bcc.school.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}