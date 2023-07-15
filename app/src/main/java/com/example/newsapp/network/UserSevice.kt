package com.example.newsapp.network


import com.example.newsapp.model.ResponseCategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserSevice {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String?
    ): Call<ResponseCategory>


}