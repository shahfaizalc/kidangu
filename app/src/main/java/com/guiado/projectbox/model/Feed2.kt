package com.guiado.projectbox.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Feed2 : Serializable {


    @SerializedName("title")
    var title: String? = null

    @SerializedName("abstract")
    var imageurl: String? = null

    @SerializedName("address")
    var baseurl: String? = null

    @SerializedName("centername")
    var articleUrl: String? = null

    @SerializedName("contact")
    var author: String? = null

    @SerializedName("department")
    var language: String? = null

    @SerializedName("location")
    val category: String? = null

    @SerializedName("subject")
    val subject: String? = null


    @SerializedName("maplocation")
    val maplocation: String? = null

}