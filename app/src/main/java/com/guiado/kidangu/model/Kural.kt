package com.guiado.kidangu.model

import com.google.gson.annotations.SerializedName

class Kural {
    @SerializedName("couplet")
    var couplet: String? = null

    @SerializedName("explanation")
    var explanation: String? = null

    @SerializedName("Line1")
    var line1: String? = null

    @SerializedName("Line2")
    var line2: String? = null

    @SerializedName("mk")
    var mk: String? = null

    @SerializedName("mv")
    var mv: String? = null

    @SerializedName("Number")
    var number: Long? = null

    @SerializedName("sp")
    var sp: String? = null

    @SerializedName("Translation")
    var translation: String? = null

    @SerializedName("transliteration1")
    var transliteration1: String? = null

    @SerializedName("transliteration2")
    var transliteration2: String? = null

}