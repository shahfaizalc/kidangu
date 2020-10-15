package com.guiado.projectbox.listeners

import com.guiado.projectbox.viewmodel.CentersViewModel
import com.guiado.projectbox.viewmodel.TopicsViewModel

interface CentersListEventListener {

    fun onClickAdSearchListItem(countriesViewModel : CentersViewModel, position: Int)
    fun launchShare(countriesViewModel : CentersViewModel, position: Int)


}