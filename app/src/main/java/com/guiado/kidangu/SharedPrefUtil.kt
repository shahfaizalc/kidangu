package com.guiado.kidangu

import android.app.Activity
import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guiado.kidangu.model.Feed

class SharedPrefUtil {

    var key = "savekey"
    fun saveSharedPref(activity: Activity, item: Feed) {
        val result: ArrayList<Feed> = getSharedPref(activity)

        var count = 0
        for(res in result) {
            if (res.articleUrl?.equals(item.articleUrl)!!) {
                count++
                return
            }
        }

        if (count == 0) {
            result.add(item)
            val gsonData = Gson().toJson(result)

            val sharedPreferences =
                activity.getSharedPreferences("production", Context.MODE_PRIVATE)

            sharedPreferences.edit().putString(key, gsonData).apply()

        }

    }


    fun getSharedPref(activity: Activity): ArrayList<Feed> {
        val sharedPreferences = activity.getSharedPreferences("production", Context.MODE_PRIVATE)
        sharedPreferences.getString("email_address", "")

        val listJson = sharedPreferences.getString(key, "")
        if (!listJson.isNullOrBlank()) {
            val type = object : TypeToken<List<Feed>>() {}.type
            return Gson().fromJson(listJson, type)
        }
        return arrayListOf()
    }
}