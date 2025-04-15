package com.coredata.myapplication.model

import com.google.gson.annotations.SerializedName


data class UniversityResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("state-province")
    val stateProvince: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("web_pages")
    val webPages: List<String>,

    @SerializedName("alpha_two_code")
    val alphaTwoCode: String,

    @SerializedName("domains")
    val domains: List<String>
)
