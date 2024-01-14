package com.example.tuna_test.base

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.tuna_test.util.LoadingIndicator


abstract class BaseActivityDataBinding<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {
    private var mViewModel: V? = null
    private var _binding: T? = null
    protected val binding get() = _binding!!
    protected lateinit var loader: LoadingIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        loader = LoadingIndicator(this, false)
        _binding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = getViewModel()
        binding.setVariable(getBindingVariable(), mViewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()

        setupParameters()
        initLayout()

    }

    abstract fun getBindingVariable(): Int

    abstract fun getViewModel(): V

    abstract fun getLayoutId(): Int

    abstract fun initLayout()

    abstract fun setupParameters()

    abstract fun setupObservers()

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}