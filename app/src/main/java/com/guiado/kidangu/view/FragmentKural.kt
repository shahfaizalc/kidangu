package com.guiado.kidangu.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.google.gson.Gson
import com.guiado.kidangu.viewmodel.KuralViewModel
import com.guiado.kidangu.R
import com.guiado.kidangu.databinding.ContentKuralBinding
import com.guiado.kidangu.model.Kural

class  FragmentKural : AppCompatActivity() {

  //  lateinit var adView: AdView

    @Transient
    var binding: ContentKuralBinding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         if (binding == null) {
             binding = DataBindingUtil.setContentView(this,
                 R.layout.content_kural
             )
             val blogUrl  = intent.getSerializableExtra("kural") as String

             var gson = Gson();
             var output =   gson.fromJson(blogUrl,Kural::class.java)

             val areaViewModel =
                 KuralViewModel(this, this, output)
             binding?.adSearchModel = areaViewModel
        //     adViewLoad()


        }
    }
//    private fun adViewLoad() {
//        adView = AdView(this, this.resources.getString(R.string.banner_home_footer), AdSize.BANNER_HEIGHT_50)
//
//        // Find the Ad Container
//        val adContainer = findViewById(R.id.banner_container) as LinearLayout
//
//        // Add the ad view to your activity layout
//        adContainer.addView(adView)
//
//        // Request an ad
//        adView.loadAd()
//
//
 //   }

    override fun onDestroy() {
//        adView.destroy()
        super.onDestroy()
    }


}