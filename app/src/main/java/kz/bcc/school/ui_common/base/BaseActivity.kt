package kz.bcc.school.ui_common.base

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import bcc.school.app.R
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

    protected fun <T : ViewModel> getViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            viewModelFactory
        )[modelClass]
    }

    /**
     * Progress dialog
     */
    private var progressDialog: ProgressDialog? = null

    protected fun showProgressDialog() {
        if (progressDialog == null
            || !progressDialog!!.isShowing
        ) {
            progressDialog = ProgressDialog.show(this, "", getString(R.string.loading), true, false)
        }
    }

    protected fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }

    /**
     * Exception
     */
    protected fun handleException(exception: Exception?) {
        ExceptionHandler.handleException(this, exception)
    }

    protected fun handleExceptionView(exception: Exception?) {
        ExceptionHandler.handleExceptionView(this, exception)
    }

    protected fun handleExceptionDialog(exception: Exception?) {
        ExceptionHandler.handleExceptionDialog(this, exception)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

}