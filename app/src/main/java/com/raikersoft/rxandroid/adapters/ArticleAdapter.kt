package com.raikersoft.rxandroid.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.raikersoft.rxandroid.R
import com.raikersoft.rxandroid.databinding.ItemArticleBinding
import com.raikersoft.rxandroid.models.Article
import com.raikersoft.rxandroid.utils.inflate
import io.reactivex.subjects.PublishSubject

/**
 * Created by RicardoAndrés on 15/09/2017.
 */
class ArticleAdapter: RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    val articleSelected = PublishSubject.create<Article>()

    var items: List<Article> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.item_article))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.article = items[position]
        holder.binding.articleSelected = articleSelected
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: ItemArticleBinding = DataBindingUtil.bind(itemView)
    }

}