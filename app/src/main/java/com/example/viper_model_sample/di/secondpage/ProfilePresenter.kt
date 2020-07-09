package com.example.viper_model_sample.di.secondpage

import com.example.viper_model_sample.entity.Profile


class ProfilePresenter(private var interactor: ProfileContract.Interactor,private var view: ProfileContract.View?)
    : ProfileContract.Presenter {


    override fun onViewCreated() {

        val profile = interactor.getProfile()
        view!!.updateUI(profile)
    }


    override fun cleanUp() {
        view = null
    }

    override fun onClickFriend(profile: Profile) {
        view!!.callToFriend(profile)
    }


}