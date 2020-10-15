package com.guiado.projectbox.model

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Feed33 : Serializable {


    @SerializedName("centerid")
    var centerid: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("address")
    var address: String? = null

    @SerializedName("contact")
    var contact: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("location")
    val location: String? = null

    @SerializedName("maplocation")
    val maplocation: String? = null

}