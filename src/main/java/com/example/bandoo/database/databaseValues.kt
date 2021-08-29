package com.example.bandoo.database

import com.example.bandoo.models.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.StorageReference


lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_UID: String
lateinit var REF_DATABASE_ROOT: DatabaseReference
lateinit var REF_STORAGE_ROOT: StorageReference
lateinit var USER: UserModel
const val TYPE_TEXT = "text"
const val NODE_USERS = "Users"
const val NODE_MESSAGES = "Message"
const val NODE_USERNAMES = "UserNames"
const val NODE_PHONES = "Phones"
const val NODE_PHONES_CONTACTS = "Phones_conatcts"
const val FOLDER_PROFILE_IMAGE = "profile_image"
const val FOLDER_FILES = "message_files"
const val CHILD_ID = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"
const val CHILD_BIO = "bio"
const val CHILD_PHOTO_URL = "photoUrl"
const val CHILD_STATE = "status"
const val CHILD_TEXT = "text"
const val CHILD_TYPE = "type"
const val CHILD_FROM = "from"
const val CHILD_TIMESTAMP = "timeStamp"
const val CHILD_FILE_URL = "fileUrl"