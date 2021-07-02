package com.example.bandoo.ui.fragments

import androidx.fragment.app.Fragment

import com.example.bandoo.R
import com.example.bandoo.utilits.replaceFragment
import com.example.bandoo.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {
    override fun onStart() {
        super.onStart()
        register_btn_next.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
        if (register_input_phone_number.text.toString().isEmpty()){
           showToast(getString(R.string.register_toast_enter_phone))
        }else{
            replaceFragment(EnterCodeFragment())
        }
    }
}
