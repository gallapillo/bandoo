package com.example.bandoo.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.bandoo.MainActivity
import com.example.bandoo.R
import com.example.bandoo.activity.RegisterActivity
import com.example.bandoo.utilits.AUTH
import com.example.bandoo.utilits.replaceActivity
import com.example.bandoo.utilits.replaceFragment

class FragmentSettings : BaseFragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())

        }
        return true
    }

}
