package com.example.tuna_test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tuna_test.BR
import com.example.tuna_test.R
import com.example.tuna_test.base.BaseActivityDataBinding
import com.example.tuna_test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivityDataBinding<ActivityMainBinding, MainActivityVM>() {
    private val vm: MainActivityVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): MainActivityVM = vm

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initLayout() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fcMain.id) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(destinationListener)
    }

    override fun setupParameters() {
    }

    override fun setupObservers() {
    }

    private val destinationListener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        when (destination.id) {
        }
    }
}