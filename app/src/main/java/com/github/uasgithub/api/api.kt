package com.github.uasgithub.api

import com.github.uasgithub.data.model.DetailUserResponse
import com.github.uasgithub.data.model.User
import com.github.uasgithub.data.model.userResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface api {
    @GET("search/users")
    @Headers("Authorization: token c9d64ebf87573d9cea49395951efd5c7d3841a07")
    fun getSearchUser(
        @Query("q") query: String
        ): Call<userResponse>


    @GET("users/{username}")
    @Headers("Authorization: token c9d64ebf87573d9cea49395951efd5c7d3841a07")
    fun getUserDetail(
            @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token c9d64ebf87573d9cea49395951efd5c7d3841a07")
    fun getFollowers(
            @Path("username") username : String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token c9d64ebf87573d9cea49395951efd5c7d3841a07")
    fun getFollowing(
            @Path("username") username : String
    ): Call<ArrayList<User>>
}