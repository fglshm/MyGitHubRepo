package com.fglshm.mygithubrepo.service

import com.fglshm.mygithubrepo.BuildConfig
import com.fglshm.mygithubrepo.api.ApiPaths
import com.fglshm.mygithubrepo.entity.User
import retrofit2.Call
import retrofit2.http.GET

interface MyGitHubService {

    @GET(BuildConfig.USERNAME)
    fun getUser(): Call<User>

}