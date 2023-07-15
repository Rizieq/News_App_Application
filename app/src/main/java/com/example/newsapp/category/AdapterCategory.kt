package com.example.newsapp.category

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.category.detailCategory.DetailCategoryActivity
import com.example.newsapp.model.ArticlesItem
import kotlinx.android.synthetic.main.item_category.view.*

class AdapterCategory(val category: List<ArticlesItem>?) : RecyclerView.Adapter<AdapterCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCategory.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return AdapterCategory.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterCategory.ViewHolder, position: Int) {
        holder.onBind(category?.get(position))


    }

    override fun getItemCount(): Int = category?.size?:0

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        fun onBind(get : ArticlesItem?){

            itemView.textView3.text = get?.title
            itemView.textView8.text = get?.author
            itemView.textView7.text = get?.publishedAt


            Log.d("LOG_DATA_Event", get?.title.toString())


            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailCategoryActivity::class.java)
                intent.putExtra("url", get?.url)
                itemView.context.startActivity(intent)
            }
        }
    }
}