package com.example.bandoo.models

data class UserModel(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "yourname",
    var status: String = "",
    var phone: String = "",
    var photoUrl: String = "https://firebasestorage.googleapis.com/v0/b/bandoo-13613.appspot.com/o/profile_image%2Fdefault_photo.png?alt=media&token=fdcdee73-66a6-400f-bc98-f84063c92e63"
)