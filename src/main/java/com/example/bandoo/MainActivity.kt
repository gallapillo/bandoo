package com.example.bandoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.bandoo.activity.RegisterActivity
import com.example.bandoo.databinding.ActivityMainBinding
import com.example.bandoo.ui.fragments.ChatsFragment
import com.example.bandoo.ui.objects.AppDrawer
import com.example.bandoo.utilits.replaceActivity
import com.example.bandoo.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart(){
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if(false){
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        }else{
            replaceActivity(RegisterActivity())
        }


    }



    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }
}
