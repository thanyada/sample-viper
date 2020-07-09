package com.example.viper_model_sample.di.firstpage

import android.view.KeyEvent
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viper_model_sample.R
import com.example.viper_model_sample.core.BaseActivity
import com.example.viper_model_sample.di.firstpage.adapter.UserAdapter
import com.example.viper_model_sample.entity.Profile
import kotlinx.android.synthetic.main.activity_main.*

class UserActivity : BaseActivity(),UserContract.View {

    private lateinit var presenter: UserPresenter
    private lateinit var interactor: UserInteractor
    private lateinit var router: UserRouter

    private val contactsAdapter : UserAdapter by lazy{
        UserAdapter { user -> presenter.onClickUser(user) }
    }

    // 1. update resource layout onCreate
    override fun getActivityLayout()  = R.layout.activity_main


    // 2. mapping Presenter , Interactor , Router to this Activity
    override fun mappingVIPER() {
        interactor = UserInteractor()
        router = UserRouter(this)
        presenter = UserPresenter(router,interactor,this)

        presenter.onViewCreated()
    }


    // 3. updateUI
    override fun updateUI(users : List<Profile>) {

        if(contactsAdapter.contacts.isEmpty()){

            rvUsers.layoutManager = LinearLayoutManager(this)
            rvUsers.adapter = contactsAdapter

        }

        contactsAdapter.contacts = users
        contactsAdapter.notifyDataSetChanged()
    }


    // 4. Destroy view and another that created
    override fun onDestroy() {
        super.onDestroy()
        presenter.cleanUp()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            presenter.onClickBackDevice()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }


    override fun showToastFirstPressedBack() {
        Toast.makeText(this, "Press back again to exit app", Toast.LENGTH_SHORT).show()
    }

}