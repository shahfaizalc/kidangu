package com.guiado.kidangu.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.*
import com.google.gson.Gson
import com.guiado.kidangu.*
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.model.Kural
import com.guiado.kidangu.view.FragmentKural
import com.guiado.kidangu.view.FragmentShortStories
import com.guiado.kidangu.view.FragmentWorld

class ShortStoriesViewModel(
    internal var activity: FragmentActivity) // To show list of user images (Gallery)
    : BaseObservable() {

    var talentProfilesList: ObservableArrayList<Feed>

 var query: Query

    var db: FirebaseFirestore

    var resetScrrollListener: Boolean = false;

    var kural : Kural

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
        val shareBody = articleUrl?.title+"\n"+articleUrl?.articleUrl+"\n\n For more articles : install our app https://play.google.com/store/apps/details?id=com.guiado.kidangu"
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
        db = FirebaseFirestore.getInstance()

//        var pref = SharedPreference(activity.applicationContext).getValueString(LANGUAGE_ID)
//        Log.d(TAG, "getProfile  "+pref)
//
//        if (pref!!.isEmpty()) {
//            pref = LanguageRegionEnum.FR.name
//        }

         var listitems = getTopicsEng()

        //   query = db.collection("/NEWS/news_arabic/world").whereEqualTo(LANGUAGE_ID, pref).whereEqualTo("regionid", RegionEnum.NIL.name).orderBy("growZoneNumber", Query.Direction.DESCENDING).limit(20)
        query = db.collection("shorts").limit(20).orderBy("date",Query.Direction.ASCENDING)

        doGetTalents()
        kural = setQuote(activity)
        name = kural.line1 +"\n"+kural.line2
    }




    fun openShare(postAdModel: Feed, position: Int) {
        //  openChooser(postAdModel, activity)
    }


    fun openFragment2(postAdModel: Feed, position: Int) {
//        val intentNext = Intent(activity, WebViewActivity::class.java)
//        intentNext.putExtra(Constants.POSTAD_OBJECT, postAdModel.newsurl)
//        activity.startActivity(intentNext)
    }

    fun openFragment3(postAdModel: Feed) {
        val intentNext = Intent(activity, FragmentWorld::class.java)
        intentNext.putExtra("feed", postAdModel)
        activity.startActivity(intentNext)
    }

    fun openFragment4(postAdModel: Int) {
        val intentNext = Intent(activity, FragmentWorld::class.java)
        intentNext.putExtra("feed", postAdModel)
        activity.startActivity(intentNext)
    }

//    private fun handleMultipleClicks(): Boolean {
//       // return MultipleClickHandler.handleMultipleClicks()
//    }


    @Override
    fun onNextButtonClick() = View.OnClickListener() {
        Log.d(TAG, "Success getting OnClickListener: ")

        val gson = Gson()
        gson.toJson(kural)


        val intentNext = Intent(activity, FragmentKural::class.java)
        intentNext.putExtra("kural", gson.toJson(kural) )
        activity.startActivity(intentNext)
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

    fun doGetTalents() {

        Log.d(TAG, "DOIT doGetTalents:")

        // talentProfilesList.clear()
        query.addSnapshotListener(MetadataChanges.INCLUDE) { querySnapshot, e ->
            if (e != null) {
                Log.w(TAG, "Listen error", e)
                return@addSnapshotListener
            }

            if (querySnapshot == null) {
                Log.i(TAG, "Listen querySnapshot end")
                return@addSnapshotListener
            }

            if (querySnapshot.size() < 1) {
                Log.i(TAG, "Listen querySnapshot end")
                return@addSnapshotListener
            }

            Log.w(TAG, "Listen querySnapshot end" + querySnapshot.size())

            val lastVisible = querySnapshot.documents[querySnapshot.size() - 1]

            query = query.startAfter(lastVisible)


            for (change in querySnapshot.documentChanges) {

                val source = if (querySnapshot.metadata.isFromCache) {
                    "local cache"
                } else {
                    "server"
                }
                if (change.type == DocumentChange.Type.ADDED) {
                    Log.d(TAG, "New city new: ")
                    addTalentsItems(change.document)
                }

                if (change.type == DocumentChange.Type.MODIFIED) {
                    Log.d(TAG, "New city modified: ")
                }
                Log.d(TAG, "Data fetched from $source")
            }
        }
    }


    fun addTalentsItems2(document: QueryDocumentSnapshot) {

        quoteimg = document.data.get("imgurl").toString()

        Log.d(TAG, "Success rachu documents: " + quoteimg)

        //  if (!adModel.postedBy.equals(mAuth.currentUser!!.uid) && (adModel.eventState.ordinal == EventStatus.SHOWING.ordinal)) {

    }

}