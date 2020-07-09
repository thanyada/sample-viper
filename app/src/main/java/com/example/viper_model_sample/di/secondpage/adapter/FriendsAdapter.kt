package com.example.viper_model_sample.di.secondpage.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viper_model_sample.R
import com.example.viper_model_sample.entity.Profile

class FriendsAdapter(private val callback : (Profile)->Unit)  : RecyclerView.Adapter<FriendsAdapter.ViewHolder>()  {

    var friends = listOf<Profile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_friend, parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return friends.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(friends[position])
        holder.itemView.setOnClickListener { callback.invoke(friends[position]) }

    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var tvAlphabelt: TextView = view.findViewById(R.id.tvAlphabelt)
        private var tvName: TextView = view.findViewById(R.id.tvName)
        private var tvInfo: TextView = view.findViewById(R.id.tvInfo)
        private var tvPhone: TextView = view.findViewById(R.id.tvPhone)
        private var tgThai: TextView = view.findViewById(R.id.tgThai)

        fun bind(user: Profile) {
            tvAlphabelt.text = user.name?.substring(0,1)?.toUpperCase()
            tvName.text = "${user.name} ${user.lastname}"
            tvInfo.text = "${if (user.gender.equals("f",true)) "Female" else "Male"} ( ${user.age} years old )"
            tvPhone.text = "tel : ${user.phoneNumber}"
            tgThai.text = if(user.isThaiNationality!!) "Thai" else "No Thai"
            val colorbg = if(user.isThaiNationality!!) Color.BLUE else Color.RED
            tgThai.setBackgroundColor(colorbg)

        }
    }

}