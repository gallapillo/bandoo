package com.example.bandoo.ui.screens

import androidx.fragment.app.Fragment
import com.example.bandoo.R
import com.example.bandoo.utilits.APP_ACTIVITY
import com.example.bandoo.utilits.AppStates
import com.example.bandoo.utilits.hideKeyboard


class MainFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Bandoo"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
    }
}
