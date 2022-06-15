package kz.bcc.school.ui.activities.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import bcc.school.app.R
import bcc.school.app.databinding.ActivityMainBinding
import kz.bcc.school.ui_common.base.BaseActivity

class MainActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        viewModel = getViewModel(MainViewModel::class.java)
        binding.viewModel = viewModel

        initView()
    }

    private fun initView() {

        navController = findNavController(R.id.nav_host_fragment)

        initToolbar()
        initOnDestinationChangedListener()
        initNavigationView()
    }

    private fun initToolbar() {
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.aboutFragment
            ),
            binding.drawerLayout
        )

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun initOnDestinationChangedListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.aboutFragment
                -> {
                    //do nothing
                }
            }
        }
    }

    private fun initNavigationView() {
        binding.navigationView.background.alpha = 90
        binding.navigationView.setupWithNavController(navController)
        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                else -> {
                    closeDrawer()
                    val result = NavigationUI.onNavDestinationSelected(it, navController)
                    binding.navigationView.setCheckedItem(it.itemId)
                    result
                }
            }
        }
    }

    private fun openDrawer() {
        binding.drawerLayout.openDrawer(binding.navigationView, true)
    }

    private fun closeDrawer() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(100)
            binding.drawerLayout.closeDrawer(binding.navigationView, true)
        }
    }

}