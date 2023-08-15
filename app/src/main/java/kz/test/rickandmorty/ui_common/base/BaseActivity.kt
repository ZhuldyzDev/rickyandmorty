package kz.test.rickandmorty.ui_common.base

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(), HasAndroidInjector {

    /**
     * DI
     */
    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

}