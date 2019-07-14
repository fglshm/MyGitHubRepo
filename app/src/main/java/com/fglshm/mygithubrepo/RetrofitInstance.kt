package com.fglshm.mygithubrepo

import com.fglshm.mygithubrepo.service.MyGitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private var retrofit: Retrofit? = null

        fun getService(): MyGitHubService? {
            retrofit?.let {
                return it.create(MyGitHubService::class.java)
            } ?: run {
                retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(MyGitHubService::class.java)
        }
    }


}