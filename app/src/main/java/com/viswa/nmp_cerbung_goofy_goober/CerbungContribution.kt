package com.viswa.nmp_cerbung_goofy_goober

import com.google.gson.annotations.SerializedName

data class CerbungContribution(@SerializedName("contribution_id") var id: Int,
                               @SerializedName("contribution_paragraph") var paragraph: String,
                               @SerializedName("contribution_like") var likes: Int,
                               @SerializedName("contribution_posted_date") var posted_date: String,
                               @SerializedName("user_id") var author_id: Int,
                               @SerializedName("user_username") var author_name: String,
                               @SerializedName("user_like_contribution") var user_like: Int = 0,
                               @SerializedName("contribution_cerbung_id") var cerbung_id: Int)
