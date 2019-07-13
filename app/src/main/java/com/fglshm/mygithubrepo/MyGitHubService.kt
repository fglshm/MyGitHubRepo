package com.fglshm.mygithubrepo

import retrofit2.Call
import retrofit2.http.GET

interface MyGitHubService {

    @GET(BuildConfig.USERNAME)
    fun getUser(): Call<User>

    @GET(ApiPaths.REPOS)
    fun getRepos(): Call<String>

}