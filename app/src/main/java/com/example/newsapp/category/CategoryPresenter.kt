package com.example.newsapp.category

import com.example.newsapp.model.ArticlesItem
import com.example.newsapp.model.ResponseCategory
import com.example.newsapp.network.ApiClient
import retrofit2.Call


class CategoryPresenter(val contract: CategoryContract) {

    fun getCategory(country: String, category: String, apikey: String){
        ApiClient.getService().getNews(country, category, apikey)
            ?.enqueue(object :retrofit2.Callback<ResponseCategory>{
                override fun onResponse(
                    call: Call<ResponseCategory>,
                    response: retrofit2.Response<ResponseCategory>
                ) {
                    if (response.isSuccessful){
                        contract.onSuccessGetCategory(response.body()?.articles as List<ArticlesItem>?)
                    }else{
                        contract.onErrorGetList(response.message())
                    }
                }

                override fun onFailure(call: Call<ResponseCategory>, t: Throwable) {
                    contract.onErrorGetList(t.localizedMessage)
                }

            })
    }
}