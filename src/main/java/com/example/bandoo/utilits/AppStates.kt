package com.example.bandoo.utilits

enum class AppStates(val state:String) {
   /* Класс перечисление состояний приложения*/

    ONLINE("в сети"),
    OFFLINE("был недавно"),
    TYPING("печатает");

    companion object{
        fun updateState(appStates: AppStates){
            if (AUTH.currentUser != null) {
                REF_DATABASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_STATE)
                    .setValue(appStates.state)
                    .addOnSuccessListener { USER.status = appStates.state }
                    .addOnFailureListener { showToast(it.message.toString()) }
            }
        }
    }
}