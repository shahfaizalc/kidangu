package com.guiado.projectbox.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guiado.projectbox.R
import com.guiado.projectbox.databinding.ContenthomeBinding
import com.guiado.projectbox.databinding.ContenttopicsBinding
import com.guiado.projectbox.viewmodel.TopicsViewModel

class  FragmentTopics : AppCompatActivity() {

    @Transient
    var binding: ContenttopicsBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contenttopics)
            val blogUrl  = intent.getSerializableExtra("feed") as Int


            val areaViewModel =
                TopicsViewModel(this, this, blogUrl)
            binding?.adSearchModel = areaViewModel


        }
    }

    override fun onDestroy() {
//        adView.destroy()
        super.onDestroy()
    }


}