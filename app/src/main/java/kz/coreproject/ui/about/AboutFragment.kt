package kz.coreproject.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import coreproject.app.R
import coreproject.app.databinding.FragmentAboutBinding
import kz.coreproject.ui_common.base.BaseFragment

class AboutFragment : BaseFragment() {

    private lateinit var binding: FragmentAboutBinding
    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = getViewModel(AboutViewModel::class.java!!)
        binding.viewModel = viewModel

        observeViewModel()
    }

    private fun observeViewModel() {
//        viewModel.openMain.observe(
//            viewLifecycleOwner,
//            Observer {
//                it.getContentIfNotHandled()?.let {
//                    val intent = MainActivity.getIntent(context)
//                    startActivity(intent)
//
//                    activity?.finish()
//                }
//            }
//        )
    }

}