package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.model.News
import kotlinx.android.synthetic.main.home.rvMain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        val listHeroes = listOf(
            News(name = "Business"),
            News(name = "Entertainment"),
            News(name = "General"),
            News(name = "Health"),
            News(name = "Science"),
            News(name = "Sports"),
            News(name = "Technology")
        )

        val heroesAdapter = HeroAdapter(listHeroes)

        rvMain.apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = heroesAdapter
        }
    }
}
