package com.example.viper_model_sample.di.secondpage

import android.content.Intent
import android.os.Handler
import com.example.viper_model_sample.R
import com.example.viper_model_sample.core.BaseActivity
import com.example.viper_model_sample.di.firstpage.UserActivity
import com.example.viper_model_sample.di.firstpage.UserContract
import com.example.viper_model_sample.di.secondpage.ProfileActivity
import com.example.viper_model_sample.entity.Profile
import com.example.viper_model_sample.utils.CommonConstant
import kotlin.random.Random

class ProfileInteractor(private val activity: ProfileActivity) : ProfileContract.Interactor {


    override fun getProfile():Profile {
        return activity.intent.getParcelableExtra<Profile>(CommonConstant.Intent.PROFILE)
    }


}