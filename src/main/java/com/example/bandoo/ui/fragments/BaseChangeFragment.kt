package com.example.bandoo.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.bandoo.MainActivity
import com.example.bandoo.R
import com.example.bandoo.utilits.hideKeyboard

/* Базовый фрагмент, от него наследуются фрагменты где происходит изменение данных о пользователе. */

open class BaseChangeFragment (layout:Int): Fragment(layout) {


    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        (activity as MainActivity).mAppDrawer.disableDrawer()
        hideKeyboard()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        /* Создание выпадающего меню*/
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /* Слушатель выбора пункта выпадающего меню */
        when (item.itemId) {
            R.id.settings_confirm_change -> change()
        }
        return true
    }

    open fun change() {

    }
}
