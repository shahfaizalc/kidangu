package com.guiado.kidangu.viewmodel

import androidx.databinding.*
import androidx.fragment.app.FragmentActivity
import com.guiado.kidangu.BR
import com.guiado.kidangu.model.Kural
import com.guiado.kidangu.view.FragmentKural


class KuralViewModel(
    internal var activity: FragmentActivity,
    internal val fragmentProfileInfo: FragmentKural,
    internal val blogUrl: Kural
) // To show list of user images (Gallery)
    : BaseObservable() {


    companion object {
        private val TAG = "DiscussionModel"
    }

    init {


    }

    @get:Bindable
    var line1: String? = blogUrl.line1
        set(value) {
            field = value
            notifyPropertyChanged(BR.line1)
        }

    @get:Bindable
    var line2: String? = blogUrl.line2
        set(value) {
            field = value
            notifyPropertyChanged(BR.line2)
        }

    @get:Bindable
    var line3: String? = blogUrl.sp
        set(value) {
            field = value
            notifyPropertyChanged(BR.line3)
        }

    @get:Bindable
    var line4: String? = "" + blogUrl.number
        set(value) {
            field = value
            notifyPropertyChanged(BR.line4)
        }



}