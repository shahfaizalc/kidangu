package com.guiado.projectbox.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.*
import com.guiado.projectbox.*
import com.guiado.projectbox.model.Feed
import com.guiado.projectbox.view.FragmentSavedStories

class SavedStoriesViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentSavedStories
) // To show list of user images (Gallery)
    : BaseObservable() {

    var talentProfilesList: ObservableArrayList<Feed>


    var resetScrrollListener: Boolean = false;


    companion object {
        private val TAG = "DiscussionModel"
    }


    @get:Bindable
    var name: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }


    fun openFragment55(postAdModel: Feed) {
        shareAppURL(postAdModel)
    }


    private fun shareAppURL(articleUrl: Feed?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody =
            articleUrl?.title + "\n" + articleUrl?.articleUrl + "\n\n For more articles : install our app https://play.google.com/store/apps/details?id=com.guiado.projectbox"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        activity.startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }


    @get:Bindable
    var quoteimg: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.quoteimg)
        }


    init {
        talentProfilesList = ObservableArrayList<Feed>()





        val result: ArrayList<Feed> = SharedPrefUtil().getSharedPref(activity)

        talentProfilesList.addAll(result);


    }


    fun openFragment3(postAdModel: Feed) {
//        val intentNext = Intent(activity, FragmentWorld::class.java)
//        intentNext.putExtra("feed", postAdModel)
//        activity.startActivity(intentNext)
    }




    @Override
    fun onNextButtonClick() = View.OnClickListener() {
        Log.d(TAG, "Success getting OnClickListener: ")

    }


    fun addTalentsItems(document: QueryDocumentSnapshot) {

        val adModel = document.toObject(Feed::class.java)

        Log.d(TAG, "Success getting documents: " + adModel.imageurl)

        //  if (!adModel.postedBy.equals(mAuth.currentUser!!.uid) && (adModel.eventState.ordinal == EventStatus.SHOWING.ordinal)) {


        //  getKeyWords(talentProfilesList,adModel)

        if (!isUpdated) {
            talentProfilesList.add(0, adModel)
        }
    }

    var isUpdated = false


    fun addTalentsItems2(document: QueryDocumentSnapshot) {

        quoteimg = document.data.get("imgurl").toString()

        Log.d(TAG, "Success rachu documents: " + quoteimg)

        //  if (!adModel.postedBy.equals(mAuth.currentUser!!.uid) && (adModel.eventState.ordinal == EventStatus.SHOWING.ordinal)) {

    }

}