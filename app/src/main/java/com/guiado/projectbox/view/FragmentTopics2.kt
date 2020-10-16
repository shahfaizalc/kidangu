package com.guiado.projectbox.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.guiado.projectbox.R
import com.guiado.projectbox.databinding.ContenthomeBinding
import com.guiado.projectbox.databinding.Contenttopics2Binding
import com.guiado.projectbox.viewmodel.Topics2ViewModel

class  FragmentTopics2 : AppCompatActivity() {

    @Transient
    var binding: Contenttopics2Binding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (binding == null) {
            binding = DataBindingUtil.setContentView(this, R.layout.contenttopics2)
            val blogUrl  = intent.getSerializableExtra("feed") as Int


            val areaViewModel =
                Topics2ViewModel(this, this, blogUrl)
            binding?.adSearchModel = areaViewModel


        }
    }

    override fun onDestroy() {
//        adView.destroy()
        super.onDestroy()
    }


}