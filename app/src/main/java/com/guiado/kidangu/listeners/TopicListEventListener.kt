package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.TopicsViewModel

interface TopicListEventListener {

    fun onClickAdSearchListItem(countriesViewModel : TopicsViewModel, position: Int)
    fun launchShare(countriesViewModel : TopicsViewModel, position: Int)


}