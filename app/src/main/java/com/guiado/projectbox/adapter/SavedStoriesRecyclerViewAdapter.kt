package com.guiado.projectbox.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.guiado.projectbox.databinding.ListItemSavedBinding
import com.guiado.projectbox.listeners.SavedEventListener
import com.guiado.projectbox.model.Feed
import com.guiado.projectbox.viewmodel.SavedStoriesViewModel

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
}