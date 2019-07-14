package com.fglshm.mygithubrepo.view.detail

import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.view.base.BaseFragment

class DetailFragment : BaseFragment() {

    private val cls = DetailFragment::class
    override fun getLayout(): Int = R.layout.fragment_detail

    companion object {
        fun newInstance() = DetailFragment()
    }

}