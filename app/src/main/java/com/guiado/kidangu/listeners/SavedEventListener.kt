package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.HomeViewModel
import com.guiado.kidangu.viewmodel.SavedStoriesViewModel
import com.guiado.kidangu.viewmodel.ShortStoriesViewModel

interface SavedEventListener {

    fun onClickAdSearchListItem(countriesViewModel : SavedStoriesViewModel, position: Int)
    fun launchShare(countriesViewModel : SavedStoriesViewModel, position: Int)
    fun launchSave(countriesViewModel : SavedStoriesViewModel, position: Int)


}