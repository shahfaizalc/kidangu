package com.guiado.kidangu.view

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.guiado.kidangu.R
import com.guiado.kidangu.databinding.ContentKuralBinding
import com.guiado.kidangu.databinding.ContenthomeBinding
import com.guiado.kidangu.databinding.ContentshortstoriesBinding
import com.guiado.kidangu.databinding.ContenttopicsBinding
import com.guiado.kidangu.viewmodel.ShortStoriesViewModel

class  FragmentShortStories : AppCompatActivity() {

    lateinit var adView: AdView

    @Transient
    var binding: ContentshortstoriesBinding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contentshortstories)


            val areaViewModel =
                ShortStoriesViewModel(this, this)
            binding?.adSearchModel = areaViewModel

            adViewLoad()

        }
    }

    private fun adViewLoad() {
        adView = AdView(this, this.resources.getString(R.string.banner_home_footer2), AdSize.BANNER_HEIGHT_50)

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