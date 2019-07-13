package com.fglshm.mygithubrepo

import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("login")
    var mLogin: String? = null

    @SerializedName("id")
    var mId: Int? = null

    @SerializedName("node_id")
    var mNodeId: String? = null

    @SerializedName("avatar_url")
    var mAvatarUrl: String? = null

    @SerializedName("gravatar_id")
    var mGravatarId: String? = null

    @SerializedName("url")
    var mUrl: String? = null

    @SerializedName("html_url")
    var mHtmlUrl: String? = null

    @SerializedName("followers_url")
    var mFollowersUrl: String? = null

    @SerializedName("following_url")
    var mFollowingUrl: String? = null

    @SerializedName("gists_url")
    var mGistsUrl: String? = null

    @SerializedName("starred_url")
    var mStarredUrl: String? = null

    @SerializedName("subscriptions_url")
    var mSubscriptionsUrl: String? = null

    @SerializedName("organizations_url")
    var mRrganizationsUrl: String? = null

    @SerializedName("repos_url")
    var mReposUrl: String? = null

    @SerializedName("events_url")
    var mEventsUrl: String? = null

    @SerializedName("received_events_url")
    var mReceivedEventsUrl: String? = null

    @SerializedName("type")
    var mType: String? = null

    @SerializedName("site_admin")
    var mSiteAdmin: String? = null

    @SerializedName("name")
    var mName: String? = null

    @SerializedName("company")
    var mCompany: String? = null

    @SerializedName("blog")
    var mBlog: String? = null

    @SerializedName("location")
    var mLocation: String? = null

    @SerializedName("email")
    var mEmail: String? = null

    @SerializedName("hireable")
    var mHireable: String? = null

    @SerializedName("bio")
    var mBio: String? = null

    @SerializedName("public_repos")
    var mPublicRepo: String? = null

    @SerializedName("public_gists")
    var mPublicGists: String? = null

    @SerializedName("followers")
    var mFollowers: String? = null

    @SerializedName("following")
    var mFollowing: String? = null

    @SerializedName("created_at")
    var mCreatedAt: String? = null

    @SerializedName("updated_at")
    var mUpdatedAt: String? = null

}