package com.fglshm.mygithubrepo.view.detail

import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.view.base.BaseActivity
import com.fglshm.mygithubrepo.view.base.BaseFragment

class DetailActivity : BaseActivity() {

    override fun getLayout(): Int = R.layout.activity_detail
    override fun getFragment(): BaseFragment = DetailFragment.newInstance()

}