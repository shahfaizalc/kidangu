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
import com.google.gson.Gson
import com.guiado.projectbox.R
import com.guiado.projectbox.databinding.ContentcenterBinding
import com.guiado.projectbox.databinding.ContenthomeBinding
import com.guiado.projectbox.databinding.ContentprojectBinding
import com.guiado.projectbox.databinding.ContenttopicsBinding
import com.guiado.projectbox.model.Feed33
import com.guiado.projectbox.viewmodel.CenterViewModel
import com.guiado.projectbox.viewmodel.ProjectViewModel
import com.guiado.projectbox.viewmodel.TopicsViewModel

class  FragmentCenter : AppCompatActivity() {

    @Transient
    var binding: ContentcenterBinding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contentcenter)
            val blogUrl  = intent.getSerializableExtra("feed") as String

            var gson = Gson();

            val areaViewModel =
                CenterViewModel(this, this, gson.fromJson<Feed33>(blogUrl,Feed33::class.java))
            binding?.adSearchModel = areaViewModel
            binding?.countriesInfoModel =  gson.fromJson<Feed33>(blogUrl,Feed33::class.java)


        }
    }


}