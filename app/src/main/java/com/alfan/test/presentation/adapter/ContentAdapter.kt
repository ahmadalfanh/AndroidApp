package com.alfan.test.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alfan.test.R
import com.alfan.test.databinding.ItemHeadlinesNewsBinding
import com.alfan.test.domain.model.ArticlesItem
import com.alfan.test.presentation.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ViewHolder>() {
    private val items = mutableListOf<ArticlesItem>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemHeadlinesNewsBinding.inflate(inflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addData(data: List<ArticlesItem>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemHeadlinesNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticlesItem) {
            with(binding) {
                tvTitleNews.text = item.title.orEmpty()
                tvDesNews.text = item.description.orEmpty()
                Glide.with(root.context)
                    .load(item.urlToImage)
                    .centerInside()
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .skipMemoryCache(true)
                    .error(R.drawable.icon_news)
                    .into(binding.ivNews)
                root.setOnClickListener {
                    DetailActivity.start(
                        root.context,
                        item.url.orEmpty(),
                    )
                }
            }
        }
    }


}