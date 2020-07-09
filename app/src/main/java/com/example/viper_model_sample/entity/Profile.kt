package com.example.viper_model_sample.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Profile (
    var name : String? ,
    var lastname : String? ,
    var phoneNumber :String? ,
    var gender  : String? ,
    var age : Int? ,
    var isThaiNationality : Boolean? ,
    var friends : ArrayList<Profile>?
) : Parcelable {
    override fun toString(): String {
        return "Profile(name=$name, lastname=$lastname, phoneNumber=$phoneNumber, gender=$gender, age=$age, isThaiNationality=$isThaiNationality, friends=$friends)"
    }
}

