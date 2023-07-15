package com.example.newsapp.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.model.ArticlesItem
import kotlinx.android.synthetic.main.activity_category.rv_category

class CategoryActivity : AppCompatActivity(),CategoryContract {
    private lateinit var presenter: CategoryPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        presenter = CategoryPresenter(this)
        presenter.getCategory("us","business", "b4ad03a115f04d83bd26923f97e0f668")
    }

    override fun onSuccessGetCategory(data: List<ArticlesItem>?) {
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_category.setLayoutManager(LinearLayoutManager(this))
        rv_category.setHasFixedSize(true)
        rv_category.setAdapter(AdapterCategory(data))
    }

    override fun onErrorGetList(msg: String?) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }
}