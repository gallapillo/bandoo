package com.example.bandoo.ui.fragments

import androidx.fragment.app.Fragment
import com.example.bandoo.R
import com.example.bandoo.utilits.APP_ACTIVITY
import com.example.bandoo.utilits.AppStates
import com.example.bandoo.utilits.hideKeyboard

class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onStart() {
        super.onStart()
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Bandoo"
        AppStates.updateState(AppStates.ONLINE)
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }

    override fun onDestroy() {
        super.onDestroy()
        AppStates.updateState(AppStates.OFFLINE)
    }
}
