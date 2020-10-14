package com.guiado.projectbox.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Storiess : Serializable {

    @SerializedName("adid")
    var adid: Int? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("thread")
    var thread: List<String> = emptyList()

    @SerializedName("author")
    var author: String? = null

    @SerializedName("date")
    var date: Timestamp? = null


    @SerializedName("language")
    var language: String? = null

}