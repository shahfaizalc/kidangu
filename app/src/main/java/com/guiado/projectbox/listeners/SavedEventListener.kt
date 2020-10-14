package com.guiado.projectbox.listeners

import com.guiado.projectbox.viewmodel.SavedStoriesViewModel

interface SavedEventListener {

    fun onClickAdSearchListItem(countriesViewModel : SavedStoriesViewModel, position: Int)
    fun launchShare(countriesViewModel : SavedStoriesViewModel, position: Int)


}