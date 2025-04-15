package com.coredata.myapplication.api

import com.coredata.myapplication.model.UniversityResponse
import retrofit2.http.GET

interface UniversityApi {
    @GET("search?name=east")
    suspend fun getUniversities(): List<UniversityResponse>
}