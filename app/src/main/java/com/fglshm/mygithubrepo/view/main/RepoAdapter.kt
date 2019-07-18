package com.fglshm.mygithubrepo.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fglshm.mygithubrepo.ItemViewHolder
import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.entity.Repository
import com.fglshm.mygithubrepo.utils.Utils
import kotlinx.android.synthetic.main.recyclerview_repo.view.*
import java.text.SimpleDateFormat
import java.util.*

class RepoAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val cls = RepoAdapter::class
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
            setTextBackground(item?.mLanguage, text_language)
            text_updated_date.text =
                Utils.Time.getTimestampText(System.currentTimeMillis(), getTimestamp(item?.mUpdatedAt ?: ""))
            text_description.text = item?.mDescription
        }
    }

    private fun setTextBackground(lang: String?, textView: TextView) {
        when (lang) {
            "Kotlin" -> textView.setBackgroundResource(R.drawable.bg_language_kt)
            "Swift" -> textView.setBackgroundResource(R.drawable.bg_language_swift)
            "Python" -> textView.setBackgroundResource(R.drawable.bg_language_py)
        }
    }

    private fun getTimestamp(dateString: String): Long {
        val str = dateString.replace(Regex("T"), " ").replace(Regex("Z"), "")
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
        val date = format.parse(str)
        return date.time.plus(9 * 60 * 60 * 1000).div(1000)
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