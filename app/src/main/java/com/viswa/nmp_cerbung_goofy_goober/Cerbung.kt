package com.viswa.nmp_cerbung_goofy_goober

import com.google.gson.annotations.SerializedName

data class Cerbung(
    @SerializedName("cerbung_id") var id: Int,
    @SerializedName("cerbung_title") var title: String,
    @SerializedName("cerbung_description") var description: String,
    @SerializedName("cerbung_display_picture") var display_picture: String,
    @SerializedName("cerbung_created_date") var created_date: String,
    @SerializedName("cerbung_like") var likes: Int,
    @SerializedName("cerbung_restricted") var restricted: Int,
    @SerializedName("genre_id") var genre_id: Int,
    @SerializedName("genre_name") var genre_name: String,
    @SerializedName("user_id") var author_id: Int,
    @SerializedName("user_name") var author_name: String,
    @SerializedName("cerbung_contribution_count") var contribution_count: Int,

)
