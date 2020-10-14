package com.guiado.projectbox.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.guiado.projectbox.listeners.TopicListEventListener
import com.guiado.projectbox.databinding.ListItemTopiclistBinding
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.viewmodel.TopicsViewModel

/**
 * News recycler view adapter to view list of items
 */
class TopicsRecyclerViewAdapter(
    private val newsViewModel: TopicsViewModel,
    private val talentProfilesList4: ObservableArrayList<Feed2>
) :
    RecyclerView.Adapter<TopicsRecyclerViewAdapter.ViewHolder>(),
    TopicListEventListener {

    /**
     * TAG
     */
    private val TAG = "ArtistRecyclerAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(ListItemTopiclistBinding.inflate(
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

    inner class ViewHolder(var binding: ListItemTopiclistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onClickAdSearchListItem(countriesViewModel: TopicsViewModel, position: Int) {
        countriesViewModel.openFragment3(talentProfilesList4[position])

    }

    override fun launchShare(countriesViewModel: TopicsViewModel, position: Int) {
        countriesViewModel.openFragment55(talentProfilesList4[position])
    }
}