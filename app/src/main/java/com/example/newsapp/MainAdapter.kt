package com.example.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.category.detailCategory.DetailCategoryActivity
import com.example.newsapp.model.News
import kotlinx.android.synthetic.main.item_home.view.text_menu

class MainAdapter(
    private val news: List<News>,
    private val listener: (News) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainViewHolder =
        MainViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_home, p0, false))

    override fun onBindViewHolder(p0: MainViewHolder, p1: Int) {
        p0.bind(news.get(0), listener)
    }

    override fun getItemCount() = 20

    inner class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(news: News, listener: (News) -> Unit) {
            view.text_menu.text = news.name
            view.setOnClickListener {
                listener(news)
                val intent = Intent(itemView.context, DetailCategoryActivity::class.java)

                itemView.context.startActivity(intent)
            }
        }
    }
}