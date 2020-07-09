package com.example.viper_model_sample.di.secondpage

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viper_model_sample.R
import com.example.viper_model_sample.core.BaseActivity
import com.example.viper_model_sample.di.secondpage.adapter.ProfileAdapter
import com.example.viper_model_sample.entity.Profile
import com.example.viper_model_sample.helper.DialogHelper
import kotlinx.android.synthetic.main.activity_main.*

class ProfileActivity : BaseActivity(), ProfileContract.View {

    private lateinit var presenter: ProfilePresenter
    private lateinit var interactor: ProfileInteractor

    private val contactsAdapter : ProfileAdapter by lazy{
        ProfileAdapter(this) { friend -> presenter.onClickFriend(friend) }
    }

    // 1. update resource layout onCreate
    override fun getActivityLayout()  = R.layout.activity_main


    // 2. mapping Presenter , Interactor , Router to this Activity
    override fun mappingVIPER() {
        interactor = ProfileInteractor(this)
        presenter = ProfilePresenter(interactor,this)

        presenter.onViewCreated()
    }

    // 3. updateUI
    override fun updateUI(profile: Profile) {

        if( contactsAdapter.profile == null){
            rvUsers.layoutManager = LinearLayoutManager(this)
            rvUsers.adapter = contactsAdapter
        }

        contactsAdapter.profile = profile
        contactsAdapter.notifyDataSetChanged()

    }


    override fun callToFriend(profile: Profile) {

        val msg = "Are you call to ${profile.name} ${profile.lastname}?"

        DialogHelper.instance(this).showTwoChoice(msg,"Call",
           onOkay = {
                //Call to phone number of this profile
        }, onCancel = {
                //Nothing
        })

    }

}