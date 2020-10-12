package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.WorldViewModel

interface WorldEventListener {

    fun onClickAdSearchListItem(countriesViewModel : WorldViewModel, position: Int)
    fun launchNews(countriesViewModel : WorldViewModel, position: Int)
    fun launchShare(countriesViewModel : WorldViewModel, position: Int)


}