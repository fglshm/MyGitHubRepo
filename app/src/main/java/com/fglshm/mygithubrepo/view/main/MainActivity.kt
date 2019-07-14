package com.fglshm.mygithubrepo.view.main

import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.view.base.BaseActivity
import com.fglshm.mygithubrepo.view.base.BaseFragment

class MainActivity : BaseActivity() {

    private val cls = MainActivity::class
    override fun getLayout(): Int = R.layout.activity_main
    override fun getFragment(): BaseFragment = MainFragment.newInstance()

}
