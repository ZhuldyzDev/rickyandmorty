package kz.bcc.school.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import bcc.school.app.R
import bcc.school.app.databinding.FragmentSplashBinding
import kz.bcc.school.ui.activities.main.MainActivity
import kz.bcc.school.ui_common.base.BaseFragment

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = getViewModel(SplashViewModel::class.java)
        binding.viewModel = viewModel

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.openMain.observe(
            viewLifecycleOwner,
            Observer {
                it.getContentIfNotHandled()?.let {
                    val intent = MainActivity.getIntent(context)
                    startActivity(intent)

                    activity?.finish()
                }
            }
        )
    }

}