package com.example.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.category.CategoryActivity
import com.example.newsapp.category.detailCategory.DetailCategoryActivity
import com.example.newsapp.model.News
import kotlinx.android.synthetic.main.item_home.view.text_menu

class HeroAdapter(private val heroes: List<News>) : RecyclerView.Adapter<HeroHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_home, viewGroup, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bindHero(heroes[position])
    }
}

class HeroHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvHeroName = view.text_menu

    fun bindHero(hero: News) {
        tvHeroName.text = hero.name
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, CategoryActivity::class.java)

            itemView.context.startActivity(intent)
        }
    }
}