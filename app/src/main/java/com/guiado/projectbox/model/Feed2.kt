package com.guiado.projectbox.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Feed2 : Serializable {


    @SerializedName("title")
    var title: String? = null

    @SerializedName("abstract")
    var abstract: String? = null

    @SerializedName("address")
    var address: String? = null

    @SerializedName("centername")
    var centername: String? = null

    @SerializedName("contact")
    var contact: String? = null

    @SerializedName("department")
    var department: String? = null

    @SerializedName("location")
    val location: String? = null

    @SerializedName("subject")
    val subject: String? = null


    @SerializedName("maplocation")
    val maplocation: String? = null

}