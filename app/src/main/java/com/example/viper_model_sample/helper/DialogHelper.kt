package com.example.viper_model_sample.helper

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AlertDialog


object DialogHelper {

    var dialog : Dialog? = null
    lateinit var context: Context

    fun instance(context : Context) : DialogHelper{

        this.context = context

        if(dialog == null){
            dialog = Dialog(context)
        }

        return this
    }


     fun showOneChoice(msg : String,choice : String = "OK",callback : (()->Unit)? = null){
         val builder: AlertDialog.Builder = AlertDialog.Builder(context)
         builder.setCancelable(false)
         builder.setMessage(msg)
         builder.setPositiveButton(choice) { dialog, id ->
             callback?.let { it.invoke() }
             dialog.dismiss()

         }
         dialog = builder.create()

        dialog!!.show()
    }

    fun showTwoChoice(msg : String,firstChoice : String = "OK",secondChoice : String = "Cancel"
                      ,onOkay : (()->Unit)? = null,onCancel : (()->Unit)? = null){
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setCancelable(false)
        builder.setMessage(msg)
        builder.setPositiveButton(firstChoice) { dialog, id ->
            onOkay?.let { it.invoke() }
            dialog.dismiss()

        }

        builder.setNegativeButton(secondChoice) { dialog, id ->
            onCancel?.let { it.invoke() }
            dialog.dismiss()

        }
        dialog = builder.create()

        dialog!!.show()
    }


}