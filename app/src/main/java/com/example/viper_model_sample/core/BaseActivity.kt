package com.example.viper_model_sample.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viper_model_sample.helper.DialogHelper
import com.example.viper_model_sample.helper.DialogProgressHelper

abstract class BaseActivity: AppCompatActivity(),BaseView {


    protected abstract fun getActivityLayout(): Int

    protected abstract fun mappingVIPER()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayout())

        mappingVIPER()

    }


    override fun showLoading() {
        DialogProgressHelper.instance(this).show()
    }

    override fun hideLoading() {
        DialogProgressHelper.instance(this).dismiss()
    }

    override fun errorMessage(str: String) {
        DialogHelper.instance(this).showOneChoice(str)
    }


}