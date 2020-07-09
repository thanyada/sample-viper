package com.example.viper_model_sample.di.firstpage.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viper_model_sample.R
import com.example.viper_model_sample.entity.Profile

class UserAdapter(private val callback : (Profile)->Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>()  {

    var contacts = listOf<Profile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_profile, parent, false)
        return ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(contacts[position])
        holder.itemView.setOnClickListener { callback.invoke(contacts[position]) }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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

}