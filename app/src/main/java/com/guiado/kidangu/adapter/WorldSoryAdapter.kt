package com.guiado.kidangu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.guiado.kidangu.R
import com.guiado.kidangu.databinding.ListItemWorldBinding
import com.guiado.kidangu.databinding.ListItemWorldstoryBinding
import com.guiado.kidangu.listeners.WorldEventListener
import com.guiado.kidangu.listeners.WorldStoryEventListener
import com.guiado.kidangu.viewmodel.WorldStoryViewModel
import com.guiado.kidangu.viewmodel.WorldViewModel

/**
 * Country recycler view adapter to view list of items
 */
class WorldSoryAdapter(private val adSearchModel: WorldStoryViewModel) :
    WorldStoryEventListener, RecyclerView.Adapter<WorldSoryAdapter.ViewHolder>(){

    private val TAG = "ArtistRecyclerAdapter"

    lateinit var context:Context

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int)
            = ViewHolder(LayoutInflater.from(viewGroup.context).inflate(
        R.layout.list_item_worldstory,
        viewGroup, false))


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val viewModel = adSearchModel

        viewHolder.binding!!.simpleListAdapter = this
        with(viewHolder.binding!!) {
            countriesInfoModel = viewModel.talentProfilesList[position]
            itemPosition = position
            mainDataModel = viewModel
            executePendingBindings()
        }
        viewHolder.binding!!.setItemClickListener(this)
    }



    override fun getItemCount()= adSearchModel.talentProfilesList.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position.let { position }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ListItemWorldstoryBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }

    override fun onClickAdSearchListItem(countriesViewModel: WorldStoryViewModel, position: Int) {
        //   Log.d(TAG,"Click: "+ countriesViewModel.talentProfilesList[position].postedBy)
       // countriesViewModel.openFragment2(countriesViewModel.talentProfilesList[position],position)

    }

    override fun launchNews(countriesViewModel: WorldStoryViewModel, position: Int) {
      //  countriesViewModel.openFragment3(countriesViewModel.talentProfilesList[position],position)
    }

    override fun launchShare(countriesViewModel: WorldStoryViewModel, position: Int) {
      //  countriesViewModel.openShare(countriesViewModel.talentProfilesList[position],position)
    }

}