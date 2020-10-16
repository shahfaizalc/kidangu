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
import com.guiado.projectbox.databinding.Contentproject2Binding
import com.guiado.projectbox.databinding.ContenttopicsBinding
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.viewmodel.Project2ViewModel
import com.guiado.projectbox.viewmodel.TopicsViewModel

class  FragmentProject2 : AppCompatActivity() {

    @Transient
    var binding: Contentproject2Binding? = null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contentproject2)
            val blogUrl  = intent.getSerializableExtra("feed") as String

            var gson = Gson();

            val areaViewModel =
                Project2ViewModel(this, this, gson.fromJson<Feed2>(blogUrl,Feed2::class.java))
            binding?.adSearchModel = areaViewModel
            binding?.countriesInfoModel =  gson.fromJson<Feed2>(blogUrl,Feed2::class.java)


        }
    }


}