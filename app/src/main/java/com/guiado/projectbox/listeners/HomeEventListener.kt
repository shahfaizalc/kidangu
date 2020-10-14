package com.guiado.projectbox.listeners

import com.guiado.projectbox.viewmodel.HomeViewModel

interface HomeEventListener {

    fun onClickAdSearchListItem(countriesViewModel : HomeViewModel, position: Int)
    fun launchShare(countriesViewModel : HomeViewModel, position: Int)
    fun launchSave(countriesViewModel : HomeViewModel, position: Int)


}