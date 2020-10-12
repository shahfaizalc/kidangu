package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.ShortStoriesViewModel

interface ShortsEventListener {

    fun onClickAdSearchListItem(countriesViewModel : ShortStoriesViewModel, position: Int)
    fun launchShare(countriesViewModel : ShortStoriesViewModel, position: Int)


}