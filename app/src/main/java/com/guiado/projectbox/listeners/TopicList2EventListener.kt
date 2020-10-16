package com.guiado.projectbox.listeners

import com.guiado.projectbox.viewmodel.Topics2ViewModel

interface TopicList2EventListener {

    fun onClickAdSearchListItem(countriesViewModel : Topics2ViewModel, position: Int)
    fun launchShare(countriesViewModel : Topics2ViewModel, position: Int)


}