package com.example.bandoo.ui.fragments

import androidx.fragment.app.Fragment
import com.example.bandoo.R
import com.example.bandoo.utilits.APP_ACTIVITY


class ChatsFragment : Fragment(R.layout.fragment_chats) {

    override fun onResume() {
        APP_ACTIVITY.title = "Чаты"
        super.onResume()
    }
}
