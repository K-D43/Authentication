package com.example.authentication.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_id") val id:String,
    val fullname:String,
    val email: String)
