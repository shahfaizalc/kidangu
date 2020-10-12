package com.guiado.kidangu

import android.app.Activity
import android.util.Log
import com.guiado.kidangu.model.Kural
import java.util.*

fun setQuote(activity: Activity ): Kural {

    val rand = Random()
    var random = rand.nextInt(12)

    Log.d("rachu","rachuuu "+random);


    val assetManager = activity.applicationContext.assets

    val readAssetFile = ReadAssetFile()
    val fileString = readAssetFile.readFile(assetManager, "thirukkural"+random+".json")

    val jsonToClassObject = JsonToClassObject(activity)
    val model = jsonToClassObject.fetchChaptersInfoJsonData(fileString)


 // var result =     model.get(0).kural!!.get(rand.nextInt(99))


//    val rand = Random() //instance of random class
//    //generate random values from 0-24
//    //generate random values from 0-24
//

    return  model.get(0).kural!!.get(rand.nextInt(99))
}

fun getTopics() = listOf("ஆன்மீகம்","வரலாறு","சினிமா","அரசியல்","பொருளாதாரம்","விளையாட்டு","அறிவியல்","கலை & கலாச்சாரம்")
fun getTopicsEng() = listOf("religion","history","cinema","politics","economy","sports","science","art")
