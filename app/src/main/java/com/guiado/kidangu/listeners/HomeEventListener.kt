package com.guiado.kidangu.listeners

import com.guiado.kidangu.viewmodel.HomeViewModel

interface HomeEventListener {

    fun onClickAdSearchListItem(countriesViewModel : HomeViewModel, position: Int)
    fun launchShare(countriesViewModel : HomeViewModel, position: Int)
    fun launchSave(countriesViewModel : HomeViewModel, position: Int)


}