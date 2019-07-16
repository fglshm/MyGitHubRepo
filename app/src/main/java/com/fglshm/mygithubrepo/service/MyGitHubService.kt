package com.fglshm.mygithubrepo.service

import com.fglshm.mygithubrepo.BuildConfig
import com.fglshm.mygithubrepo.api.ApiPaths
import com.fglshm.mygithubrepo.entity.Repository
import com.fglshm.mygithubrepo.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyGitHubService {

    @GET(BuildConfig.USERNAME)
    fun getUser(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String
    ): Call<User>

    @GET("${BuildConfig.USERNAME}/${ApiPaths.REPOS}")
    fun getRepos(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String
    ): Call<List<Repository>>

}