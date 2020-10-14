package com.guiado.kidangu.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.google.gson.Gson
import com.guiado.kidangu.R
import com.guiado.kidangu.viewmodel.WorldViewModel
import com.guiado.kidangu.databinding.ContentWorldBinding
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.model.Storiess

class  FragmentWorld : AppCompatActivity() {

    lateinit var adView: AdView

    @Transient
    var binding: ContentWorldBinding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         if (binding == null) {
             binding = DataBindingUtil.setContentView(this,
                 R.layout.content_world
             )
             val blogUrl  = intent.getSerializableExtra("feed") as String


             var gson = Gson();
             var output =   gson.fromJson(blogUrl, Feed::class.java)


             val areaViewModel =
                 WorldViewModel(this, this, output)
             binding?.adSearchModel = areaViewModel
              val nameObserver = Observer<Feed> { firstName ->
                binding!!.countriesInfoModel = firstName
            }

            binding?.adSearchModel!!.getCurrentName().observe(this, nameObserver)
             adViewLoad()

        }
    }


    private fun adViewLoad() {
        adView = AdView(this, this.resources.getString(R.string.banner_home_footer3), AdSize.BANNER_HEIGHT_50)

        // Find the Ad Container
        val adContainer = findViewById(R.id.banner_container) as LinearLayout

        // Add the ad view to your activity layout
        adContainer.addView(adView)

        // Request an ad
        adView.loadAd()


    }


    override fun onDestroy() {
//        adView.destroy()
        super.onDestroy()
    }


}