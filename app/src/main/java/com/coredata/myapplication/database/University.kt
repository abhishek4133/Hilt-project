package com.coredata.myapplication.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "university")
data class University(
    @PrimaryKey val name: String,
    val stateProvince: String? = null,
    val country: String? = null,
    val webPages: List<String>? = null,
    val alphaTwoCode: String? = null,
    val domains: List<String>? = null,
)

