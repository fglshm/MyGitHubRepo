package com.fglshm.mygithubrepo.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fglshm.extensions2.scale
import com.fglshm.extensions2.showLogD
import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.RetrofitInstance
import com.fglshm.mygithubrepo.api.OAuth.clientId
import com.fglshm.mygithubrepo.api.OAuth.clientSecret
import com.fglshm.mygithubrepo.entity.Repository
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
    private val mRepoAdapter by lazy { RepoAdapter() }
    private val mRepoText by lazy { text_repo }

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val apiService = RetrofitInstance.getService()

        apiService?.getUser(clientId, clientSecret)?.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                cls.showLogD("FAILURE USER")
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                val user = response.body()
                setupView(user)
            }
        })

        apiService?.getRepos(clientId, clientSecret)?.enqueue(object : Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                cls.showLogD("FAILURE REPOS")
            }

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                val repoList = response.body()
                repoList?.let {
                    val repoText = "Repository (${it.size})"
                    mRepoText.text = repoText
                    mRepoAdapter.add(it)
                }
            }
        })
    }

    private fun setupView(user: User?) {
        Glide.with(this).load(user?.mAvatarUrl).into(mProfileImageView)
    }

    private fun setupRecyclerView() {
        mRecyclerView.adapter = mRepoAdapter
        mRecyclerView.addItemDecoration(LinearItemDecoration(mActivity.scale(), 12))
    }


}