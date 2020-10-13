package com.guiado.kidangu.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.guiado.kidangu.BR
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.model.Storiess
import com.guiado.kidangu.view.FragmentWorld
import com.guiado.kidangu.view.FragmentWorldStory


class WorldStoryViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentWorldStory,
    internal val blogUrl: Storiess
) // To show list of user images (Gallery)
    : BaseObservable() {

    var talentProfilesList: ObservableArrayList<String>
    object FirstName: MutableLiveData<Feed>()

    fun getCurrentName(): MutableLiveData<Feed> {
        return FirstName
    }

    var resetScrrollListener : Boolean = false;

    companion object {
        private val TAG = "DiscussionModel"
    }


    @get:Bindable
    var title: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @get:Bindable
    var author: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.author)
        }


    init {
        talentProfilesList = ObservableArrayList()

        addTalentsItems()
    }

    fun openFragment55(postAdModel: Feed) {
        shareAppURL(postAdModel)
    }

    private fun shareAppURL(articleUrl: Feed?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = articleUrl?.title+"\n"+articleUrl?.articleUrl+"\n\n For more articles : install our app https://play.google.com/store/apps/details?id=com.guiado.kidangu"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        activity.startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

    fun openFragment3(postAdModel: Feed, position: Int) {
//        val intentNext = Intent(activity, WebViewActivity::class.java)
//        intentNext.putExtra(Constants.POSTAD_OBJECT, postAdModel.homeurl)
//        activity.startActivity(intentNext)
    }

    @Override
    fun onNextButtonClick() = View.OnClickListener() {
     //   if(!handleMultipleClicks()) {

       // }
    }


    fun addTalentsItems() {

        val adModel = blogUrl

        Log.d(TAG, "Success getting documents: " + adModel)

            talentProfilesList.addAll(adModel.thread)
            title = adModel.title.toString()
            author = adModel.author.toString()

    }


}