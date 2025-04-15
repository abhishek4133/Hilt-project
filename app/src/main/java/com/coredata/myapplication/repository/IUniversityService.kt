package com.coredata.myapplication.repository

import com.coredata.myapplication.model.UniversityResponse

interface IUniversityService {
    suspend fun getUniversities(): List<UniversityResponse>
}