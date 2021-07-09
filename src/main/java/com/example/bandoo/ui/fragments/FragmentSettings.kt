package com.example.bandoo.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.bandoo.MainActivity
import com.example.bandoo.R
import com.example.bandoo.activity.RegisterActivity
import com.example.bandoo.utilits.*
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_settings.*

class FragmentSettings : BaseFragment(R.layout.fragment_settings) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        setting_bio.text = USER.bio
        settings_full_name.text = USER.fullname
        setting_phone_number.text = USER.phone
        settings_status.text = USER.status
        setting_username.text = USER.username
        setting_btn_change_username.setOnClickListener {
            replaceFragment(ChangeUserNameFragment())
        }
        setting_btn_change_bio.setOnClickListener {
            replaceFragment(ChangeBioFragment())
        }
        setting_change_photo.setOnClickListener { changePhotoUser() }
    }

    private fun changePhotoUser() {
        CropImage.activity().setAspectRatio(1,1).setRequestedSize(600,600)
            .setCropShape(CropImageView.CropShape.OVAL).start(APP_ACTIVITY)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                APP_ACTIVITY.replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())

        }
        return true
    }

}
