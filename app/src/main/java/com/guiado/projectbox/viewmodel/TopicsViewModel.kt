package com.guiado.projectbox.viewmodel

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import com.google.firebase.firestore.*
import com.google.gson.Gson
import com.guiado.projectbox.*
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.view.FragmentProoject
import com.guiado.projectbox.view.FragmentTopics

class TopicsViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentTopics,
    internal val itempostion: Int
) // To show list of user images (Gallery)
    : BaseObservable() {

    var talentProfilesList: ObservableArrayList<Feed2>

    var query: Query

    var db: FirebaseFirestore

    var resetScrrollListener: Boolean = false;

   // var kural : Kural

    companion object {
        private val TAG = "DiscussionModel"
    }


    @get:Bindable
    var name: String = String()
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


    @get:Bindable
    var title: String = String()
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }



    init {
        talentProfilesList = ObservableArrayList<Feed2>()
        db = FirebaseFirestore.getInstance()

//        var pref = SharedPreference(activity.applicationContext).getValueString(LANGUAGE_ID)
//        Log.d(TAG, "getProfile  "+pref)
//
//        if (pref!!.isEmpty()) {
//            pref = LanguageRegionEnum.FR.name
//        }

         var listitems = getTopicsEng()

        var titletopic = getTopics();
        title = titletopic.get(itempostion)

        //   query = db.collection("/NEWS/news_arabic/world").whereEqualTo(LANGUAGE_ID, pref).whereEqualTo("regionid", RegionEnum.NIL.name).orderBy("growZoneNumber", Query.Direction.DESCENDING).limit(20)
        query = db.collection("chennai").limit(20)

        doGetTalents()
      //  kural = setQuote(activity)
     //   name = kural.line1 +"\n"+kural.line2
    }


    fun openFragment55(postAdModel: Feed2) {
        shareAppURL(postAdModel)
    }


    private fun shareAppURL(articleUrl: Feed2?) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = articleUrl?.title+"\n"+articleUrl?.title+"\n\n For more articles : install our app https://play.google.com/store/apps/details?id=com.guiado.projectbox"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        activity.startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }




    fun openFragment3(postAdModel: Feed2) {
        val intentNext = Intent(activity, FragmentProoject::class.java)
        var gson = Gson()

        intentNext.putExtra("feed", gson.toJson(postAdModel))
        activity.startActivity(intentNext)
    }



    fun doGetTalentsSearch(searchQuery: String) {
        query = db.collection("discussion")
            .whereArrayContainsAny("searchTags", getCommbinationWords(searchQuery).toList())
            .limit(20)

        Log.d(TAG, "DOIT doGetTalentsSearch: ")
        talentProfilesList.removeAll(talentProfilesList)
        doGetTalents()

    }

    private fun getCommbinationWords(s: String): List<String> {
        val list1 = s.sentenceToWords()
        Log.d("list2", "indian" + list1)
        return list1
    }




    @Override
    fun onNextButtonClick() = View.OnClickListener() {
        Log.d(TAG, "Success getting OnClickListener: ")

        doGetTalentsSearch(name)
    }


    fun addTalentsItems(document: QueryDocumentSnapshot) {

        val adModel = document.toObject(Feed2::class.java)

        Log.d(TAG, "Success getting documents: " + adModel.title)

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