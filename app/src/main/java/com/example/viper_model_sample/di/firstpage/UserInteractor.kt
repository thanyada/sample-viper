package com.example.viper_model_sample.di.firstpage

import android.os.Handler
import com.example.viper_model_sample.R
import com.example.viper_model_sample.core.BaseActivity
import com.example.viper_model_sample.entity.Profile
import kotlin.random.Random

class UserInteractor : UserContract.Interactor {


    private val mockProfiles : List<Profile> by lazy{
        arrayListOf(
            Profile(
                name = "Gena",
                lastname = "Aggle",
                age = 12,
                gender = "f",
                phoneNumber = "01-2343456",
                isThaiNationality = false,
                friends = mockFriend()
            ),

            Profile(
                name = "Gena",
                lastname = "Aggle",
                age = 12,
                gender = "f",
                phoneNumber = "01-2343456",
                isThaiNationality = false,
                friends = mockFriend()
            ),
            Profile(
                name = "Liz",
                lastname = "Smith",
                age = 15,
                gender = "m",
                phoneNumber = "02-3343456",
                isThaiNationality = true,
                friends = mockFriend()
            ),
            Profile(
                name = "Elizabeth",
                lastname = "Jones",
                age = 42,
                gender = "f",
                phoneNumber = "02-3943456",
                isThaiNationality = false,
                friends = mockFriend()
            ),
            Profile(
                name = "Guerrero",
                lastname = "Williams",
                age = 52,
                gender = "m",
                phoneNumber = "09-2343456",
                isThaiNationality = false,
                friends = mockFriend()
            ),
            Profile(
                name = "Ada",
                lastname = "Taylor",
                age = 10,
                gender = "f",
                phoneNumber = "08-2343456",
                isThaiNationality = false,
                friends = mockFriend()
            ),
            Profile(
                name = "Alfonso",
                lastname = "Smith",
                age = 15,
                gender = "f",
                phoneNumber = "01-23344456",
                isThaiNationality = true,
                friends = mockFriend()
            ),
            Profile(
                name = "Edgar",
                lastname = "Davies",
                age = 16,
                gender = "f",
                phoneNumber = "02-53434555",
                isThaiNationality = true,
                friends = mockFriend()
            ),
            Profile(
                name = "Hoover",
                lastname = "Thomas",
                age = 22,
                gender = "m",
                phoneNumber = "09-1343456",
                isThaiNationality = true,
                friends = mockFriend()
            ),
            Profile(
                name = "Maria",
                lastname = "Johnson",
                age = 34,
                gender = "m",
                phoneNumber = "062-343456",
                isThaiNationality = false,
                friends = mockFriend()
            ),
            Profile(
                name = "Mary",
                lastname = "Roberts",
                age = 30,
                gender = "m",
                phoneNumber = "02-0346669",
                isThaiNationality = true,
                friends = mockFriend()
            )
        )
    }

    
    override fun getUsers(onSuccess: (List<Profile>) -> Unit, onError: (Throwable) -> Unit) {

        //replace Call Real API
        Handler().postDelayed({

            onSuccess.invoke( mockProfiles ) 

        }, 2000)
        
    }

    private fun mockFriend(): ArrayList<Profile> {

        val friends = arrayListOf<Profile>()
        val gender = listOf("f","m")

        for ( i in 1..Random.nextInt(5,20)){
            friends.add(
                Profile(
                    name = "Name$i",
                    lastname = "Lastname$i",
                    age = Random.nextInt(1,60),
                    gender = gender[Random.nextInt(0,1)],
                    phoneNumber = "081-${Random.nextLong(1000000,9999999)}",
                    isThaiNationality = Random.nextBoolean(),
                    friends = null
                )
            )
        }
        return friends

    }


}