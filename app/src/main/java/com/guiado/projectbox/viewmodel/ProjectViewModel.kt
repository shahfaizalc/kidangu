package com.guiado.projectbox.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.*
import com.guiado.projectbox.BR
import com.guiado.projectbox.model.Feed
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.view.FragmentProoject
import com.guiado.projectbox.view.FragmentTopics

class ProjectViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentProoject,
    internal  val feed2 : Feed2
) // To show list of user images (Gallery)
    : BaseObservable() {


    companion object {
        private val TAG = "DiscussionModel"
    }


    @get:Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }


    @get:Bindable
    var quoteimg: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.quoteimg)
        }


    init {
        doGetTalents()
    }




    private fun shareAppURL(articleUrl: Feed?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = articleUrl?.title+"\n"+articleUrl?.articleUrl+"\n\n For more articles : install our app https://play.google.com/store/apps/details?id=com.guiado.projectbox"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        activity.startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }


    fun openFragment4(postAdModel: Int) {
        if (postAdModel!=0) {

        val intentNext = Intent(activity, FragmentTopics::class.java)
        intentNext.putExtra("feed", postAdModel)
        activity.startActivity(intentNext)
    }
    }

//    private fun handleMultipleClicks(): Boolean {
//       // return MultipleClickHandler.handleMultipleClicks()
//    }


    @Override
    fun onNextButtonClick() = View.OnClickListener() {
        Log.d(TAG, "Success getting OnClickListener: ")

    }



    @Override
    fun onNextButtonClick2() = View.OnClickListener() {
//        Log.d(TAG, "Success getting OnClickListener: ")
//        val intentNext = Intent(activity, FragmentShortStories::class.java)
//        activity.startActivity(intentNext)
    }

    var counter =0;
    fun addTalentsItems(adModel: Feed) {

       // val adModel = document.toObject(Feed::class.java)

    }

    var isUpdated = false

    fun doGetTalents() {

        Log.d(TAG, "DOIT doGetTalents:")


    }




}