package com.alfan.test.utils.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * BaseFragment for keeping an instance of [ViewDataBinding]
 */

abstract class DataBindingFragment<VB : ViewDataBinding> : Fragment() {
    private var loadingDialog: LoadingDialog? = null
    private var isLoading = false


    private var _vb: VB? = null
    protected lateinit var binding: VB

    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vb = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        binding = _vb!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreatedFragment(savedInstanceState)
        loadingDialog = LoadingDialog()
    }

    fun showLoading(isCancelable: Boolean) {
        if (context == null) return
        if (loadingDialog != null && !isLoading) {
            isLoading = true
            loadingDialog?.showLoading(context)
            loadingDialog?.mDialog?.setCancelable(isCancelable)
            loadingDialog?.mDialog?.setCanceledOnTouchOutside(isCancelable)

        }
    }

    fun dismissLoading() {
        if (loadingDialog?.mDialog != null && isLoading) {
            isLoading = false
            loadingDialog?.mDialog?.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyViewFragment()
        _vb = null
    }

    abstract fun onViewCreatedFragment(savedInstanceState: Bundle?)

    open fun onDestroyViewFragment() {}
}