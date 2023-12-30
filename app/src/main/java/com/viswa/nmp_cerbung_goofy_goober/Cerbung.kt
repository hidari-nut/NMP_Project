package com.viswa.nmp_cerbung_goofy_goober

data class Cerbung(
    var cerbung_id: Int,
    var title: String,
    var description: String,
    var display_picture: String,
    var created_date: String,
    var likes: Int,
    var restricted: Int,
    var genre_id: Int,
    var genre_name: String,
    var author_id: Int,
    var author_name: String,

)
