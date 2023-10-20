package com.viswa.nmp_cerbung_goofy_goober

data class Genre(val id: Int, val name: String){
    override fun toString(): String {
        return name
    }
}
