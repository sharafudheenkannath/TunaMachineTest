package com.example.tuna_test.util

import android.app.Dialog
import android.content.Context
import com.example.tuna_test.R

class LoadingIndicator(context: Context, isCancelable: Boolean = false) {

    /**
     * Initializing the dialog
     */
    private var dialog = Dialog(context, R.style.loaderDialogTheme).apply {
        setCanceledOnTouchOutside(isCancelable)
        setCancelable(isCancelable)
        setContentView(R.layout.layout_loading_indicator)
    }

    /**
     * Method to show the loading indicator
     */
    fun show() {
        dialog.apply {
            if (!isShowing) show()
        }
    }

    /**
     * Method to hide the loading indicator
     */
    fun hide() {
        dialog.apply {
            if (isShowing) dismiss()
        }
    }
}