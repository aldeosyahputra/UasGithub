package com.github.uasgithub.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.uasgithub.api.RetrofitClient
import com.github.uasgithub.data.model.User
import com.github.uasgithub.data.model.userResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    val listUsers = MutableLiveData<ArrayList<User>>()

    fun SearchUses(query: String){
        RetrofitClient.apiInstance
                .getSearchUser(query)
                .enqueue(object : Callback<userResponse>{
                    override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
                        if (response.isSuccessful){
                            listUsers.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<userResponse>, t: Throwable) {
                        Log.d("Failure", t.message!!)
                    }

                })
    }

    fun getSearchUsers(): LiveData<ArrayList<User>>{
        return listUsers
    }




}