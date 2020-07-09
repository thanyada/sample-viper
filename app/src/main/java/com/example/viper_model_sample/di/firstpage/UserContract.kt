package com.example.viper_model_sample.di.firstpage

import com.example.viper_model_sample.entity.Profile
import com.example.viper_model_sample.core.BaseView
import kotlin.reflect.KFunction


interface UserContract {

    interface View : BaseView{
        fun updateUI(users : List<Profile>)
        fun showToastFirstPressedBack()
    }

    interface Presenter{

        fun onViewCreated()
        fun cleanUp()
        fun onClickUser(profile : Profile)
        fun onClickBackDevice()
    }

    interface Interactor{
        fun getUsers(onSuccess : (List<Profile>) -> Unit,onError : (Throwable) -> Unit)
    }

    interface Router{
        fun backInMainApp()
        fun gotoProfileDetail(profile : Profile)
    }
}