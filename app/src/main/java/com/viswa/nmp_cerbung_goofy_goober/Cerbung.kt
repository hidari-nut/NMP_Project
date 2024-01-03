package com.viswa.nmp_cerbung_goofy_goober

import com.google.gson.annotations.SerializedName

data class Cerbung(
    @SerializedName("cerbung_id") var id: Int = 0,
    @SerializedName("cerbung_title") var title: String = "",
    @SerializedName("cerbung_description") var description: String = "",
    @SerializedName("cerbung_display_picture") var display_picture: String = "",
    @SerializedName("cerbung_created_date") var created_date: String = "",
    @SerializedName("cerbung_like") var likes: Int = 0,
    @SerializedName("cerbung_restricted") var restricted: Int = 0,
    @SerializedName("genre_id") var genre_id: Int = 0,
    @SerializedName("genre_name") var genre_name: String = "",
    @SerializedName("user_id") var author_id: Int = 0,
    @SerializedName("user_username") var author_name: String = "",
    @SerializedName("user_like_cerbung") var user_like: Int = 0,
    @SerializedName("user_follow_cerbung") var user_follow: Int = 0,
    @SerializedName("user_add_permission") var user_permitted: Int = 0,
    @SerializedName("cerbung_contribution_count") var contribution_count: Int = 0,

)
