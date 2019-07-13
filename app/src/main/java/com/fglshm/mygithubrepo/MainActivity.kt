package com.fglshm.mygithubrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fglshm.extensions2.showLogD

class MainActivity : AppCompatActivity() {

    private val cls = MainActivity::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cls.showLogD("Hello")
    }
}
