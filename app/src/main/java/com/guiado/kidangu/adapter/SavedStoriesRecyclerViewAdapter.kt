package com.guiado.kidangu.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.guiado.kidangu.databinding.ListItemSavedBinding
import com.guiado.kidangu.listeners.ShortsEventListener
import com.guiado.kidangu.databinding.ListItemShortsBinding
import com.guiado.kidangu.listeners.SavedEventListener
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.viewmodel.HomeViewModel
import com.guiado.kidangu.viewmodel.SavedStoriesViewModel
import com.guiado.kidangu.viewmodel.ShortStoriesViewModel

/**
 * News recycler view adapter to view list of items
 */
class SavedStoriesRecyclerViewAdapter(
    private val newsViewModel: SavedStoriesViewModel,
    private val talentProfilesList4: ObservableArrayList<Feed>
) :
    RecyclerView.Adapter<SavedStoriesRecyclerViewAdapter.ViewHolder>(),
    SavedEventListener {

    /**
     * TAG
     */
    private val TAG = "ArtistRecyclerAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(ListItemSavedBinding.inflate(
        LayoutInflater.from(
        parent.context), parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("viewed","view")
        val viewModel = newsViewModel
        viewHolder.binding.simpleListAdapter = this
        with(viewHolder.binding) {
            countriesInfoModel = talentProfilesList4[(position)]
            itemPosition = position
            mainDataModel = viewModel
          //  itemVisibility = View.VISIBLE
            executePendingBindings()
        }
        viewHolder.binding.setItemClickListener(this)
    }

    override fun getItemCount() = talentProfilesList4.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position.let { position }

    inner class ViewHolder(var binding: ListItemSavedBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onClickAdSearchListItem(countriesViewModel: SavedStoriesViewModel, position: Int) {
        countriesViewModel.openFragment3(talentProfilesList4[position])

    }

    override fun launchShare(countriesViewModel: SavedStoriesViewModel, position: Int) {
        countriesViewModel.openFragment55(talentProfilesList4[position])

    }

    override fun launchSave(countriesViewModel: SavedStoriesViewModel, position: Int) {
        countriesViewModel.openFragment65(talentProfilesList4[position])
        notifyDataSetChanged()


    }
}