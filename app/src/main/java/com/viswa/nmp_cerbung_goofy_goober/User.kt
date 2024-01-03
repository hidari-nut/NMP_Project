package com.viswa.nmp_cerbung_goofy_goober

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_id") var userId: Number,
    @SerializedName("user_username") var username: String,
    @SerializedName("user_profile_picture") var profile_picture: String,
    @SerializedName("user_created_date") var created_date: String,
)
