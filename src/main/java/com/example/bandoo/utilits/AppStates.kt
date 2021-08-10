package com.example.bandoo.utilits

enum class AppStates(val state: String) {
    ONLINE("В сети"),
    OFFLINE("Был недавно"),
    TYPING("Печатает");

    companion object {
        fun updateState(appStates: AppStates) {
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_STATE)
                .setValue(appStates.state)
                .addOnSuccessListener { USER.status = appStates.state }
                .addOnFailureListener { showToast(it.message.toString()) }

        }
    }
}