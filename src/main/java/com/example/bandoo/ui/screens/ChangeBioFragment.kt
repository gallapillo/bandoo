package com.example.bandoo.ui.screens

import com.example.bandoo.R
import com.example.bandoo.database.*
import com.example.bandoo.utilits.AppStates
import kotlinx.android.synthetic.main.fragment_cnage_bio.*


class ChangeBioFragment : BaseChangeFragment(R.layout.fragment_cnage_bio) {

    override fun onResume() {
        super.onResume()
        settings_input_bio.setText(USER.bio)
        AppStates.updateState(AppStates.ONLINE)
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        setBioToDatabase(newBio)
    }
}
