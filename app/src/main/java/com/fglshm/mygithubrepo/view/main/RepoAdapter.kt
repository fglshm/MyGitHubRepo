package com.fglshm.mygithubrepo.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fglshm.mygithubrepo.ItemViewHolder
import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.entity.Repository
import kotlinx.android.synthetic.main.recyclerview_repo.view.*

class RepoAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val mItems: MutableList<Repository?> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_repo, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = mItems[position]
        holder.itemView.apply {
            text_repo_name.text = item?.mName
            text_language.text = item?.mLanguage
            when (item?.mLanguage) {
                "Kotlin" -> text_language.setBackgroundResource(R.drawable.bg_language_kt)
                "Swift" -> text_language.setBackgroundResource(R.drawable.bg_language_swift)
                "Python" -> text_language.setBackgroundResource(R.drawable.bg_language_py)
            }

        }
    }

    fun add(what: Repository) {
        mItems.add(what)
        notifyItemInserted(itemCount)
    }

    fun add(what: List<Repository>) {
        mItems.addAll(what)
        notifyDataSetChanged()
    }
}