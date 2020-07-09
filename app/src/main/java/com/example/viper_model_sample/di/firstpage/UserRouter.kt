package com.example.viper_model_sample.di.firstpage

import android.content.Intent
import android.os.Handler
import com.example.viper_model_sample.R
import com.example.viper_model_sample.core.BaseActivity
import com.example.viper_model_sample.di.secondpage.ProfileActivity
import com.example.viper_model_sample.entity.Profile
import com.example.viper_model_sample.utils.CommonConstant
import kotlin.random.Random

class UserRouter(private val activity:UserActivity) : UserContract.Router {

    override fun backInMainApp() {
        activity.finish()
    }

    override fun gotoProfileDetail(profile: Profile) {
        activity.startActivity(Intent(activity , ProfileActivity::class.java)
            .putExtra(CommonConstant.Intent.PROFILE,profile))
    }


}