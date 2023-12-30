package com.viswa.nmp_cerbung_goofy_goober

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genre_id") val id: Int,
    @SerializedName("genre_name") val name: String){
    override fun toString(): String {
        return name
    }
}
