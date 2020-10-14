package com.guiado.projectbox

import android.app.Activity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guiado.projectbox.model.Tirukural


class JsonToClassObject(internal var fragmentYearRecyclerView: Activity) {


    fun fetchChaptersInfoJsonData( fileString :String) : ArrayList<Tirukural> {
        return  convertChaptersInfoJsonStringToClassObject(fileString);
    }

    private fun convertChaptersInfoJsonStringToClassObject(jsonString: String) : ArrayList<Tirukural>{
        val listType = object : TypeToken<ArrayList<Tirukural>>() {}.type
        return Gson().fromJson(jsonString, listType)
    }


}