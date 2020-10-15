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
import com.guiado.projectbox.databinding.ContenthomeBinding
import com.guiado.projectbox.databinding.ContentprojectBinding
import com.guiado.projectbox.databinding.ContenttopicsBinding
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.viewmodel.ProjectViewModel
import com.guiado.projectbox.viewmodel.TopicsViewModel

class  FragmentProoject : AppCompatActivity() {

    @Transient
    var binding: ContentprojectBinding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contentproject)
            val blogUrl  = intent.getSerializableExtra("feed") as String

            var gson = Gson();

            val areaViewModel =
                ProjectViewModel(this, this, gson.fromJson<Feed2>(blogUrl,Feed2::class.java))
            binding?.adSearchModel = areaViewModel
            binding?.countriesInfoModel =  gson.fromJson<Feed2>(blogUrl,Feed2::class.java)


        }
    }


}