package com.guiado.projectbox.view

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
import com.guiado.projectbox.R
import com.guiado.projectbox.databinding.ContentcentersBinding
import com.guiado.projectbox.databinding.ContenthomeBinding
import com.guiado.projectbox.databinding.ContentsavedstoriesBinding
import com.guiado.projectbox.databinding.ContenttopicsBinding
import com.guiado.projectbox.viewmodel.CentersViewModel
import com.guiado.projectbox.viewmodel.SavedStoriesViewModel
import com.guiado.projectbox.viewmodel.TopicsViewModel

class  FragmentCenters : Fragment() {

    lateinit var adView: AdView

    @Transient
    var binding: ContentcentersBinding? = null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return bindView(inflater, container)
    }

    private fun bindView(inflater: LayoutInflater, container: ViewGroup?): View {
        if (binding == null) {
            binding = DataBindingUtil.inflate<ContentcentersBinding>(
                inflater,
                R.layout.contentcenters,
                container,
                false
            )
            val areaViewModel = CentersViewModel(requireActivity(), this,2)
            binding?.adSearchModel = areaViewModel

        }
        adViewLoad(binding!!.root)

        return binding!!.root
    }


    private fun adViewLoad(root: View) {
        adView = AdView(
            this.activity,
            this.resources.getString(R.string.banner_home_footer),
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