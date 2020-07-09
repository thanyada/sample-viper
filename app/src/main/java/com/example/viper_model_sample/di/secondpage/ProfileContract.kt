package com.example.viper_model_sample.di.secondpage

import com.example.viper_model_sample.entity.Profile
import com.example.viper_model_sample.core.BaseView
import kotlin.reflect.KFunction


interface ProfileContract {

    interface View : BaseView{
        fun updateUI(profile : Profile)
        fun callToFriend(profile : Profile)
    }

    interface Presenter{
        fun onViewCreated()
        fun cleanUp()
        fun onClickFriend(profile : Profile)
    }

    interface Interactor{
        fun getProfile():Profile
    }
}