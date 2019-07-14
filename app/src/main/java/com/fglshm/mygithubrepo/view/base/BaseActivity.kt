package com.fglshm.mygithubrepo.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fglshm.extensions2.transact
import com.fglshm.mygithubrepo.R
import com.fglshm.mygithubrepo.view.main.MainFragment

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayout(): Int
    abstract fun getFragment(): BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        supportFragmentManager.transact {
            replace(R.id.container_activity_main, MainFragment.newInstance(), MainFragment::class.java.simpleName)
        }
    }

}