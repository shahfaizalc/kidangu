package com.guiado.kidangu.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.guiado.kidangu.listeners.HomeEventListener
import com.guiado.kidangu.databinding.ListItemHomeBinding
import com.guiado.kidangu.model.Feed
import com.guiado.kidangu.viewmodel.HomeViewModel

/**
 * News recycler view adapter to view list of items
 */
class NewsRecyclerViewAdapter(
    private val newsViewModel: HomeViewModel,
    private val talentProfilesList4: ObservableArrayList<Feed>
) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>(),
    HomeEventListener {

    /**
     * TAG
     */
    private val TAG = "ArtistRecyclerAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(ListItemHomeBinding.inflate(
        LayoutInflater.from(
        parent.context), parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("viewed","vieweee")
        val viewModel = newsViewModel
        with(viewHolder.binding) {
            Log.d("viewed","vieweede "+talentProfilesList4[position].baseurl)
            countriesInfoModel = talentProfilesList4[(position)]
            itemPosition = position
            mainDataModel = viewModel
            postDate = talentProfilesList4[position].baseurl
            keyWordsTag = talentProfilesList4[position].imageurl
        }
        viewHolder.binding.simpleListAdapter = this
        viewHolder.binding.itemClickListener = this
        viewHolder.binding.executePendingBindings()

    }

    override fun getItemCount() = talentProfilesList4.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position.let { position }

    inner class ViewHolder(var binding: ListItemHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onClickAdSearchListItem(countriesViewModel: HomeViewModel, position: Int) {
        countriesViewModel.openFragment3(talentProfilesList4[position])

    }

    override fun launchShare(countriesViewModel: HomeViewModel, position: Int) {
        countriesViewModel.openFragment55(talentProfilesList4[position])

    }

    override fun launchSave(countriesViewModel: HomeViewModel, position: Int) {
        countriesViewModel.openFragment65(talentProfilesList4[position])

    }
}