package com.example.viper_model_sample.di.firstpage

import android.os.Handler
import android.util.Log
import com.example.viper_model_sample.entity.Profile


class UserPresenter(private val router: UserContract.Router,
                    private val interactor: UserContract.Interactor,
                    private var view: UserContract.View?)
    : UserContract.Presenter {


    private var backPressedTime : Int = 0

    override fun onViewCreated() {

        view!!.showLoading()

        interactor.getUsers({
            view!!.updateUI(it)
            view!!.hideLoading()

        }, { err -> view!!.errorMessage(err.message ?: "Server Error") })

    }

    override fun onClickUser(profile: Profile) {
        router.gotoProfileDetail(profile)
    }

    override fun onClickBackDevice() {

        backPressedTime++
        Log.i("onClickBackDevice","backPressedTime : $backPressedTime")

        when (backPressedTime) {
            1 -> {
                view!!.showToastFirstPressedBack()
            }
            2 -> {
                router.backInMainApp()
            }
            else -> {
                Handler().postDelayed({
                    backPressedTime =0
                }, 5000)
            }
        }
    }

    override fun cleanUp() {
        view = null
    }


}