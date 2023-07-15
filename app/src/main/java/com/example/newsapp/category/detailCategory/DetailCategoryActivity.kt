package com.example.newsapp.category.detailCategory


import android.os.Bundle
import android.webkit.WebView

import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.R



class DetailCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intentUrlDetail = intent.getStringExtra("url")
        val myWebView: WebView = findViewById(R.id.webView)
        myWebView.loadUrl(intentUrlDetail.toString())


    }

}