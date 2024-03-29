package com.fglshm.mygithubrepo.entity

import com.google.gson.annotations.SerializedName

class License {

    @SerializedName("key")
    var mKey: String? = null

    @SerializedName("name")
    var mName: String? = null

    @SerializedName("spdx_id")
    var mSpdxId: String? = null

    @SerializedName("url")
    var mUrl: String? = null

    @SerializedName("node_id")
    var mNodeId: String? = null

}