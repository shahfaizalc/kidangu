package com.guiado.kidangu.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.view.FragmentWorld


class WorldViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentWorld,
    internal val blogUrl: Feed
) // To show list of user images (Gallery)
    : BaseObservable() {

    var talentProfilesList: ObservableArrayList<String>
    object FirstName: MutableLiveData<Feed>()

    fun getCurrentName(): MutableLiveData<Feed> {
        return FirstName
    }


   // var query : Query
  //  var db :FirebaseFirestore

    var resetScrrollListener : Boolean = false;

    companion object {
        private val TAG = "DiscussionModel"
    }

    init {
        talentProfilesList = ObservableArrayList()
     //   db = FirebaseFirestore.getInstance()

//        var pref = SharedPreference(activity.applicationContext).getValueString(LANGUAGE_ID)
//        Log.d(TAG, "getProfile  "+pref)
//
//        if (pref!!.isEmpty()) {
//            pref = LanguageRegionEnum.FR.name
//        }
     //   query = db.collection("/NEWS/news_arabic/world").whereEqualTo(LANGUAGE_ID, pref).whereEqualTo("regionid", RegionEnum.NIL.name).orderBy("growZoneNumber", Query.Direction.DESCENDING).limit(20)
      //  query = db.collection("articles").limit(20)


        addTalentsItems()
    }


    fun openShare(postAdModel: Feed, position: Int) {
      //  openChooser(postAdModel, activity)
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



    fun openFragment2(postAdModel: Feed, position: Int) {
//        val intentNext = Intent(activity, WebViewActivity::class.java)
//        intentNext.putExtra(Constants.POSTAD_OBJECT, postAdModel.newsurl)
//        activity.startActivity(intentNext)
    }

    fun openFragment3(postAdModel: Feed, position: Int) {
//        val intentNext = Intent(activity, WebViewActivity::class.java)
//        intentNext.putExtra(Constants.POSTAD_OBJECT, postAdModel.homeurl)
//        activity.startActivity(intentNext)
    }

//    private fun handleMultipleClicks(): Boolean {
//       // return MultipleClickHandler.handleMultipleClicks()
//    }

    @Override
    fun onNextButtonClick() = View.OnClickListener() {
     //   if(!handleMultipleClicks()) {

       // }
    }


    fun addTalentsItems() {

        val adModel = blogUrl

        Log.d(TAG, "Success getting documents: " + adModel.imageurl)

        //  if (!adModel.postedBy.equals(mAuth.currentUser!!.uid) && (adModel.eventState.ordinal == EventStatus.SHOWING.ordinal)) {


        //  getKeyWords(talentProfilesList,adModel)

        if(!isUpdated) {

            getCurrentName().value =  adModel
            talentProfilesList.addAll(adModel.thread)
          //  talentProfilesList.add(0,adModel)
            //talentProfilesList.add(adModel)
        }
        // }
    }

    var isUpdated = false
//
//    fun doGetTalents() {
//
//        Log.d(TAG, "DOIT doGetTalents:")
//
//        // talentProfilesList.clear()
//        query.addSnapshotListener(MetadataChanges.INCLUDE) { querySnapshot, e ->
//            if (e != null) {
//                Log.w(TAG, "Listen error", e)
//                return@addSnapshotListener
//            }
//
//            if (querySnapshot == null) {
//                Log.i(TAG, "Listen querySnapshot end")
//                return@addSnapshotListener
//            }
//
//            if (querySnapshot.size() < 1) {
//                Log.i(TAG, "Listen querySnapshot end")
//                return@addSnapshotListener
//            }
//
//            Log.w(TAG, "Listen querySnapshot end"+querySnapshot.size())
//
//            val lastVisible = querySnapshot.documents[querySnapshot.size() - 1]
//
//            query = query.startAfter(lastVisible)
//
//
//            for (change in querySnapshot.documentChanges) {
//
//                val source = if (querySnapshot.metadata.isFromCache) {
//                    "local cache"
//                } else{
//                    "server"
//                }
//                if (change.type == DocumentChange.Type.ADDED) {
//                    Log.d(TAG, "New city new: ")
//                    addTalentsItems(change.document)
//                }
//
//                if (change.type == DocumentChange.Type.MODIFIED) {
//                    Log.d(TAG, "New city modified: ")
//                }
//                Log.d(TAG, "Data fetched from $source")
//            }
//        }
//    }

}