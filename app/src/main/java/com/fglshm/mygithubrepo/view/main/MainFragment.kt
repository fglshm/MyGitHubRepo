package com.fglshm.mygithubrepo.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fglshm.extensions2.showLogD
import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.RetrofitInstance
import com.fglshm.mygithubrepo.entity.User
import com.fglshm.mygithubrepo.view.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.recyclerview_repo.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : BaseFragment() {

    private val cls = MainFragment::class
    override fun getLayout(): Int = R.layout.fragment_main

    private val mProfileImageView by lazy { image_profile_main }
    private val mRecyclerView by lazy { recycler_fragment_main }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apiService = RetrofitInstance.getService()
        val call = apiService?.getUser()

        call?.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                cls.showLogD("FAILURE")
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()
                setupView(user)
            }
        })
    }

    private fun setupView(user: User?) {
        Glide.with(this).load(user?.mAvatarUrl).into(mProfileImageView)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mRecyclerView.adapter = RepoAdapter(
            listOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        )
    }

    class RepoAdapter(
        private val items: List<String>
    ) : RecyclerView.Adapter<RepoAdapter.ItemViewHolder>() {
        class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_repo, parent, false)
            return ItemViewHolder(view)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.itemView.apply {
                text_repo_name.text = position.toString()
            }
        }
    }

}