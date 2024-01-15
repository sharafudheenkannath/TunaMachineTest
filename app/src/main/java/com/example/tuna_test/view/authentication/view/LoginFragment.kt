package com.example.tuna_test.view.authentication.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tuna_test.BR
import com.example.tuna_test.R
import com.example.tuna_test.base.BaseFragmentDataBinding
import com.example.tuna_test.databinding.FragmentLoginBinding
import com.example.tuna_test.util.DataResult
import com.example.tuna_test.view.authentication.viewmodel.LoginFragmentVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragmentDataBinding<FragmentLoginBinding, LoginFragmentVM>() {
    private val vm: LoginFragmentVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getViewModel(): LoginFragmentVM = vm

    override fun getLayoutId(): Int = R.layout.fragment_login

    override fun initLayout() {
    }

    override fun setupObservers() {
        vm.loginSuccess.observe(viewLifecycleOwner) {
            when (it.status) {
                DataResult.Status.SUCCESS -> {
                    loader.hide()
                    findNavController().navigate(LoginFragmentDirections.actionRoomListFragment())
                }

                DataResult.Status.ERROR -> {
                    loader.hide()
                    showToast(it.message.toString())
                }

                DataResult.Status.LOADING -> {
                    loader.show()
                }
            }
        }
        vm.toastMessage.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }


}