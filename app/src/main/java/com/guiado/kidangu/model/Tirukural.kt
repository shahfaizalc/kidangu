package com.guiado.kidangu.model

import com.google.gson.annotations.SerializedName
import com.guiado.kidangu.model.Kural

class Tirukural {
    @SerializedName("kural")
    var kural: List<Kural>? = null

}