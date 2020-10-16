package com.guiado.projectbox.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.guiado.projectbox.listeners.TopicList2EventListener
import com.guiado.projectbox.databinding.ListItemTopiclist2Binding
import com.guiado.projectbox.model.Feed2
import com.guiado.projectbox.viewmodel.Topics2ViewModel

/**
 * News recycler view adapter to view list of items
 */
class Topics2RecyclerViewAdapter(
    private val newsViewModel: Topics2ViewModel,
    private val talentProfilesList4: ObservableArrayList<Feed2>
) :
    RecyclerView.Adapter<Topics2RecyclerViewAdapter.ViewHolder>(),
    TopicList2EventListener {

    /**
     * TAG
     */
    private val TAG = "ArtistRecyclerAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(ListItemTopiclist2Binding.inflate(
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

    inner class ViewHolder(var binding: ListItemTopiclist2Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onClickAdSearchListItem(countriesViewModel: Topics2ViewModel, position: Int) {
        countriesViewModel.openFragment3(talentProfilesList4[position])

    }

    override fun launchShare(countriesViewModel: Topics2ViewModel, position: Int) {
        countriesViewModel.openFragment55(talentProfilesList4[position])
    }
}