package com.guiado.kidangu.handler

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guiado.kidangu.adapter.NewsRecyclerViewAdapter
import com.guiado.kidangu.theapp.EndlessRecyclerViewScrollListener
import com.guiado.kidangu.viewmodel.HomeViewModel

/**
 *  Class to handle recyclerview scroll listner and to initiate server call
 */
class RecyclerLoadMoreHomeHandler(private val countriesViewModel: HomeViewModel,
                                  private val listViewAdapter: NewsRecyclerViewAdapter
) {

    private val TAG = "Discussion"

    fun scrollListener(recyclerView: RecyclerView, linearLayoutManager: LinearLayoutManager) {

        val listener = object : EndlessRecyclerViewScrollListener(linearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {

                Log.d(TAG, "initRequest: sub scrollListener ")
               // countriesViewModel.doGetTalents()
            }
        }
        recyclerView.addOnScrollListener(listener)
    }

    fun notifyAdapter(view: RecyclerView, curSize: Int) {
        view.post { listViewAdapter.notifyDataSetChanged() }
    }

    fun clearRecycleView(recyclerView: RecyclerView) {
        recyclerView.post { listViewAdapter.notifyItemRangeInserted(0, 0) }
    }

    fun resetRecycleView(recyclerView: RecyclerView) {
        countriesViewModel.talentProfilesList = countriesViewModel.talentProfilesList
        notifyAdapter(recyclerView, countriesViewModel.talentProfilesList.size)
    }

}
