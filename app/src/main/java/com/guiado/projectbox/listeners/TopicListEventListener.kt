package com.guiado.projectbox.listeners

import com.guiado.projectbox.viewmodel.TopicsViewModel

interface TopicListEventListener {

    fun onClickAdSearchListItem(countriesViewModel : TopicsViewModel, position: Int)
    fun launchShare(countriesViewModel : TopicsViewModel, position: Int)


}