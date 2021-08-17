package com.example.bandoo.ui.fragments

import androidx.fragment.app.Fragment
import com.example.bandoo.utilits.APP_ACTIVITY
import com.example.bandoo.utilits.AppStates

open class BaseFragment( layout:Int) : Fragment(layout) {

    override fun onStart() {
        super.onStart()
        APP_ACTIVITY.mAppDrawer.disableDrawer()
        AppStates.updateState(AppStates.ONLINE)
    }

}
