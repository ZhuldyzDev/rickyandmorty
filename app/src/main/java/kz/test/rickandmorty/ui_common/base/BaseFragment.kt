package kz.test.rickandmorty.ui_common.base

import android.app.ProgressDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kz.test.rickandmorty.R
import kz.test.rickandmorty.di.utils.Injectable
import javax.inject.Inject

open class BaseFragment : Fragment(), Injectable {

    /**
     * DI
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected fun <T : ViewModel> getViewModel(modelClass: Class<T>): T {
        return ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(modelClass)
    }


    /**
     * Progress dialog
     */
    private var progressDialog: ProgressDialog? = null

    protected fun showProgressDialog() {
        if (progressDialog == null
            || !progressDialog!!.isShowing
        ) {
            progressDialog =
                ProgressDialog.show(context, "", getString(R.string.loading), true, false)
        }
    }
    protected fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }


    protected fun handleExceptionDialog(exception: Exception?) {
        context?.let {
            ExceptionHandler.handleExceptionDialog(it, exception)
        }
    }
}