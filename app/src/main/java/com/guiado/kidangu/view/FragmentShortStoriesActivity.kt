package com.guiado.kidangu.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.facebook.ads.AdSize
import com.facebook.ads.AdView
import com.guiado.kidangu.R
import com.guiado.kidangu.databinding.*
import com.guiado.kidangu.viewmodel.SavedStoriesViewModel
import com.guiado.kidangu.viewmodel.ShortStoriesViewModel

class  FragmentShortStoriesActivity : Fragment() {

    lateinit var adView: AdView


    @Transient
    var binding: ContentshortstoriesBinding? = null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return bindView(inflater, container)
    }

    private fun bindView(inflater: LayoutInflater, container: ViewGroup?): View {
        if (binding == null) {
            binding = DataBindingUtil.inflate<ContentshortstoriesBinding>(
                inflater,
                R.layout.contentshortstories,
                container,
                false
            )
            val areaViewModel = ShortStoriesViewModel(requireActivity())
            binding?.adSearchModel = areaViewModel

        }
        adViewLoad(binding!!.root)

        return binding!!.root
    }


    private fun adViewLoad(root: View) {
        adView = AdView(
            this.activity,
            this.resources.getString(R.string.banner_home_footer2),
            AdSize.BANNER_HEIGHT_50
        )

        // Find the Ad Container
        val adContainer = root.findViewById(R.id.banner_container) as LinearLayout

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