package com.example.bandoo.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.bandoo.MainActivity
import com.example.bandoo.R
import com.example.bandoo.activity.RegisterActivity
import com.example.bandoo.utilits.*
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.fragment_settings.*

class FragmentSettings : BaseFragment(R.layout.fragment_settings) {


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        APP_ACTIVITY.title = "Настройки"
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
        setting_user_photo.downloadAndSetImage(USER.photoUrl)
    }

    private fun changePhotoUser() {
        CropImage.activity().setAspectRatio(1,1).setRequestedSize(600,600)
            .setCropShape(CropImageView.CropShape.OVAL).start(APP_ACTIVITY, this)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            val uri = CropImage.getActivityResult(data).uri
            val path = REF_STORAGE_ROOT.child(FOLDER_PROFILE_IMAGE).child(UID)
            
            putImageToStorage(uri, path) {
                getUrlFromStorage(path) {
                    putUrlToDatabase(it) {
                        showToast(getString(R.string.toast_data_update))
                        setting_user_photo.downloadAndSetImage(it)
                        USER.photoUrl = it
                        APP_ACTIVITY.mAppDrawer.updateHeader()
                    }
                }
            }
        }
    }
}
