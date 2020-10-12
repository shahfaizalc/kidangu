package com.guiado.kidangu.theapp

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.BulletSpan
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.BufferType
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guiado.kidangu.*
import com.guiado.kidangu.adapter.*
import com.guiado.kidangu.handler.*
import com.guiado.kidangu.viewmodel.*
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation





@BindingAdapter("app:searchRecycler8")
fun adapter8(recyclerView: RecyclerView, countriesViewModel: SavedStoriesViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = SavedStoriesRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList
    )
    val bindingAdapter =
        RecyclerLoadMoreSavedHandler(
            countriesViewModel,
            listAdapter
        )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}






@BindingAdapter("app:searchRecycler7")
fun adapter7(recyclerView: RecyclerView, countriesViewModel: ShortStoriesViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = ShortStoriesRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList
    )
    val bindingAdapter =
        RecyclerLoadMoreShortsHandler(
            countriesViewModel,
            listAdapter
        )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}





@BindingAdapter("app:searchRecycler4")
fun adapter6(recyclerView: RecyclerView, countriesViewModel: TopicsViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = TopicsRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList
    )
    val bindingAdapter =
        RecyclerLoadMoreTopicsHandler(
            countriesViewModel,
            listAdapter
        )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}







@BindingAdapter("app:searchRecycler5")
fun adapter5(recyclerView: RecyclerView, countriesViewModel: HomeViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = News2RecyclerViewAdapter(
        countriesViewModel,
        getTopics()
    )

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
}




@BindingAdapter("app:searchRecycler4")
fun adapter4(recyclerView: RecyclerView, countriesViewModel: HomeViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = NewsRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList4
    )
    val bindingAdapter = RecyclerLoadMoreHomeHandler(
        countriesViewModel,
        listAdapter
    )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList4.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}


@BindingAdapter("app:searchRecycler3")
fun adapter3(recyclerView: RecyclerView, countriesViewModel: HomeViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = NewsRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList3
    )
    val bindingAdapter = RecyclerLoadMoreHomeHandler(
        countriesViewModel,
        listAdapter
    )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList3.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}


@BindingAdapter("app:searchRecycler2")
fun adapter2(recyclerView: RecyclerView, countriesViewModel: HomeViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = NewsRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList2
    )
    val bindingAdapter = RecyclerLoadMoreHomeHandler(
        countriesViewModel,
        listAdapter
    )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList2.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}


@BindingAdapter("app:searchRecycler")
fun adapter(recyclerView: RecyclerView, countriesViewModel: HomeViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = NewsRecyclerViewAdapter(
        countriesViewModel,
        countriesViewModel.talentProfilesList
    )
    val bindingAdapter = RecyclerLoadMoreHomeHandler(
        countriesViewModel,
        listAdapter
    )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}


@BindingAdapter("app:searchRecycler")
fun adapter(recyclerView: RecyclerView, countriesViewModel: WorldViewModel) {

    val linearLayoutManager =
        LinearLayoutManager(recyclerView.context)//, LinearLayoutManager.HORIZONTAL, false);
    val listAdapter = WorldAdapter(countriesViewModel)
    val bindingAdapter = RecyclerLoadMoreWorldHandler(
        countriesViewModel,
        listAdapter
    )
    bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
    recyclerView.addItemDecoration(CirclePagerIndicatorDecoration())
    //val snapHelper: SnapHelper = PagerSnapHelper()
    //snapHelper.attachToRecyclerView(recyclerView)

    recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager
    recyclerView.adapter = listAdapter
    countriesViewModel.talentProfilesList.addOnListChangedCallback(object :
        ObservableList.OnListChangedCallback<ObservableList<String>>() {
        override fun onItemRangeRemoved(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach1")
        }

        override fun onItemRangeMoved(
            sender: ObservableList<String>?,
            fromPosition: Int,
            toPosition: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach2")
        }

        override fun onItemRangeInserted(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach3")
            bindingAdapter.resetRecycleView(recyclerView)
            if (countriesViewModel.resetScrrollListener) {
                bindingAdapter.scrollListener(recyclerView, linearLayoutManager)
                countriesViewModel.resetScrrollListener = false
            }

        }

        override fun onItemRangeChanged(
            sender: ObservableList<String>?,
            positionStart: Int,
            itemCount: Int
        ) {
            Log.d("rach", "rach4")
            bindingAdapter.resetRecycleView(recyclerView)
        }

        override fun onChanged(sender: ObservableList<String>?) {
            Log.d("rach", "rach5")
            bindingAdapter.resetRecycleView(recyclerView)
        }

    });

}

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    val i = TextUtils.isEmpty(imageUrl)

    if (i) {
        view.setImageDrawable(view.getContext().getDrawable(R.drawable.ic_launcher_background))
    } else {
        val radius = 30
        val margin = 30
        val transformation: Transformation = RoundedCornersTransformation(radius, margin)
        Picasso.get()
            .load(imageUrl)
            .error(R.drawable.ic_launcher_foreground)
            .placeholder(R.drawable.ic_launcher_foreground)
            .transform(transformation)
            .into(view)
    }
}

@BindingAdapter("mainText")
fun format(
    textView: TextView,
    mainText: String?
) {
    val sb = StringBuilder()
    val markers: MutableList<Int> = ArrayList()
    System.out.println("mainTextlength "+mainText!!.length)


    for (i in 0 until mainText!!.length) {
        val ch: Char = mainText.get(i)
        when (ch) {
            '*' ->
                // we found a bullet, mark the start of bullet span but don't append the bullet char
            {
                sb.append('\n')
                markers.add(i + 1)
            }
            else ->  {
                // any other character just add it to the string
                sb.append(ch)
            }
        }
    }

    //  create the spannable to put in the TextView
    val spannableString = SpannableString(sb.toString())

    var i = 0
    while (i < markers.size) {
        val start = markers[i]
        spannableString.setSpan(
            BulletSpan(10, Color.GRAY),
            start,
            start + 1,
            Spannable.SPAN_POINT_POINT
        )
        Log.d("TAGGER", "TAGG" + start)
        i += 1
    }


    textView.setText(spannableString, BufferType.SPANNABLE)
}