package com.guiado.projectbox.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.*
import com.google.gson.Gson
import com.guiado.projectbox.BR
import com.guiado.projectbox.SharedPrefUtil
import com.guiado.projectbox.model.Feed
import com.guiado.projectbox.view.FragmentHome
import com.guiado.projectbox.view.FragmentTopics

class HomeViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentHome
) // To show list of user images (Gallery)
    : BaseObservable() {



    var query: Query
    var imgquery: Query

    var db: FirebaseFirestore

    var resetScrrollListener: Boolean = false;


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

        db = FirebaseFirestore.getInstance()

//        var pref = SharedPreference(activity.applicationContext).getValueString(LANGUAGE_ID)
//        Log.d(TAG, "getProfile  "+pref)
//
//        if (pref!!.isEmpty()) {
//            pref = LanguageRegionEnum.FR.name
//        }
        //   query = db.collection("/NEWS/news_arabic/world").whereEqualTo(LANGUAGE_ID, pref).whereEqualTo("regionid", RegionEnum.NIL.name).orderBy("growZoneNumber", Query.Direction.DESCENDING).limit(20)
        query = db.collection("articles").orderBy("date",Query.Direction.ASCENDING).limit(30)
        imgquery = db.collection("dailyimage")

        doGetTalents()
        doGetTalents2()
    }


    private var selectedItemPosition = 0

    @Bindable
    fun getSelectedItemPosition(): Int {
        return selectedItemPosition
    }

    fun setSelectedItemPosition(selectedItemPosition: Int) {
        this.selectedItemPosition = selectedItemPosition
        Log.d(TAG, "Success getting OnClickListener: $selectedItemPosition")
        notifyPropertyChanged(BR.selectedItemPosition)
        openFragment4(this.selectedItemPosition)
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


        db.collection("articles").orderBy("date",Query.Direction.DESCENDING).limit(20).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {

                    val gson = Gson()
                    val json = gson.toJson(document.data )

                   var trs = gson.fromJson(json,Feed::class.java)
                    Log.w(TAG, "Error getting racha: "+trs.date)


                     addTalentsItems(trs)
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }.addOnCompleteListener { task ->
                  if (task.isSuccessful) {
                      // Document found in the offline cache
                      val document = task.result
                      Log.d(TAG, "Cached document data: ${document}")
                  } else {
                      Log.d(TAG, "Cached get failed: ", task.exception)
                  }
              }



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
//            Log.w(TAG, "Listen querySnapshot end" + querySnapshot.size())
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
//                } else {
//                    "server"
//                }
//                if (change.type == DocumentChange.Type.ADDED) {
//                    Log.d(TAG, "New city new: "+change.document)
//                    addTalentsItems(change.document)
//                }
//
//                if (change.type == DocumentChange.Type.MODIFIED) {
//                    Log.d(TAG, "New city modified: ")
//                }
//                Log.d(TAG, "Data fetched from $source")
//            }
//        }
    }


    fun doGetTalents2() {

        Log.d(TAG, "DOIT doGetTalents2:")

        // talentProfilesList.clear()
        imgquery.addSnapshotListener(MetadataChanges.INCLUDE) { querySnapshot, e ->
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


            for (change in querySnapshot.documentChanges) {

                val source = if (querySnapshot.metadata.isFromCache) {
                    "local cache"
                } else {
                    "server"
                }
                if (change.type == DocumentChange.Type.ADDED) {
                    Log.d(TAG, "New city new: ")
                    addTalentsItems2(change.document)
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