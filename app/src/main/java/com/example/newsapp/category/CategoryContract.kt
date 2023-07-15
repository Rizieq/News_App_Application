package com.example.newsapp.category

import com.example.newsapp.model.ArticlesItem

interface CategoryContract {
    //getListProduk
    fun onSuccessGetCategory(data: List<ArticlesItem>?)
    fun onErrorGetList(msg: String?)


}