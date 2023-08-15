package kz.test.rickandmorty.ui.activities.splash

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kz.test.rickandmorty.R
import kz.test.rickandmorty.databinding.ActivitySplashBinding
import kz.test.rickandmorty.ui_common.base.BaseActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        navController = findNavController(R.id.nav_host_fragment)
    }

}