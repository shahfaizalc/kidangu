package com.guiado.kidangu.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Feed : Serializable {

    @SerializedName("adid")
    var adid: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("imageurl")
    var imageurl: String? = null

    @SerializedName("baseurl")
    var baseurl: String? = null

    @SerializedName("thread")
    var thread: List<String> = emptyList()

    @SerializedName("tag")
    var tag: List<String> = emptyList()

    @SerializedName("articleUrl")
    var articleUrl: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("date")
    var date: String? = null

    @SerializedName("language")
    var language: String? = null

    @SerializedName("category")
    val category: List<String> = emptyList()

}