package com.example.viper_model_sample.helper

import android.app.ProgressDialog
import android.content.Context

object DialogProgressHelper{

    var dialog : ProgressDialog? = null

    fun instance(context : Context) : DialogProgressHelper{
        if(dialog == null){
            dialog = ProgressDialog(context)
            dialog?.setMessage("loading")
        }

        return this
    }


     fun show(){
        dialog?.show()
    }

    fun dismiss(){
        dialog?.let {
            dialog?.dismiss()
        }
    }

}