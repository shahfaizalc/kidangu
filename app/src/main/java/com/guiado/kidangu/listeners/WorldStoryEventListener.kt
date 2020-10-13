package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.WorldStoryViewModel
import com.guiado.kidangu.viewmodel.WorldViewModel

interface WorldStoryEventListener {

    fun onClickAdSearchListItem(countriesViewModel : WorldStoryViewModel, position: Int)
    fun launchNews(countriesViewModel : WorldStoryViewModel, position: Int)
    fun launchShare(countriesViewModel : WorldStoryViewModel, position: Int)


}