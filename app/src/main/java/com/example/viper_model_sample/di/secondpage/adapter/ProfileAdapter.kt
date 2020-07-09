package com.example.viper_model_sample.di.secondpage.adapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viper_model_sample.R
import com.example.viper_model_sample.entity.Profile
import kotlinx.android.synthetic.main.activity_main.*

class ProfileAdapter(val context : Context, private val callback : (Profile)->Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    private val NOT_ANYTHING = 0
    private val MY_PROFILE = 1
    private val TITLE_FRIENDS = 2
    private  val MY_FRIENDS = 3

    var profile :Profile ? = null

    private val friendAdapter : FriendsAdapter by lazy{
        FriendsAdapter { friend -> callback.invoke(friend) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when(viewType){
            MY_PROFILE -> {
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_profile, parent, false)
                return MyProfiletViewHolder(itemView)
            }

            TITLE_FRIENDS ->{
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_title_friends, parent, false)
                return TitleViewHolder(itemView)
            }

            else ->{
                val itemView = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_recycle, parent, false)
                return MyFriendViewHolder(itemView)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        if(itemCount == 1) return MY_PROFILE

        if(itemCount == 3) {
            if(position == 0)  return MY_PROFILE
            if(position == 1)  return TITLE_FRIENDS
            return MY_FRIENDS
        }

        return NOT_ANYTHING
    }


    override fun getItemCount(): Int {

        return profile?.let { profile ->
            profile.friends?.let {  3
            } ?: 1
        } ?: 0

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType){

            MY_PROFILE -> {
                val h = holder as MyProfiletViewHolder
                h.bind(profile!!)
            }

            TITLE_FRIENDS -> {
                val h = holder as TitleViewHolder
                h.bind(profile!!.friends!!.size)
            }

            MY_FRIENDS -> {
                val h = holder as MyFriendViewHolder
                h.bind(profile!!.friends!!)
            }

        }

    }


    inner class MyFriendViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var rv: RecyclerView = view.findViewById(R.id.rv)


        fun bind(friends: List<Profile>) {

            if( friendAdapter.friends.isEmpty()){
                rv.apply {
                    layoutManager =  GridLayoutManager(context,3)
                    adapter = friendAdapter
                }
            }
            friendAdapter.friends = friends
            friendAdapter.notifyDataSetChanged()
        }
    }

    inner class MyProfiletViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvAlphabelt: TextView = view.findViewById(R.id.tvAlphabelt)
        private var tvName: TextView = view.findViewById(R.id.tvName)
        private var tvAge: TextView = view.findViewById(R.id.tvAge)
        private var tvGender: TextView = view.findViewById(R.id.tvGender)
        private var tvPhone: TextView = view.findViewById(R.id.tvPhone)
        private var tgThai: TextView = view.findViewById(R.id.tgThai)

        fun bind(user: Profile) {
            tvAlphabelt.text = user.name?.substring(0,1)?.toUpperCase()
            tvName.text = "${user.name} ${user.lastname}"
            tvAge.text = "age : ${user.age}"
            tvGender.text = "gender : ${user.gender}"
            tvPhone.text = "tel : ${user.phoneNumber}"
            tgThai.text = if(user.isThaiNationality!!) "Thai" else "No Thai"
            val colorbg = if(user.isThaiNationality!!) Color.BLUE else Color.RED
            tgThai.setBackgroundColor(colorbg)

         }
    }

    inner class TitleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvTitleFriend: TextView = view.findViewById(R.id.tvTitleFriend)

        fun bind(countFriends : Int) {
            tvTitleFriend.text = "My Friends ( $countFriends )"
        }
    }

}