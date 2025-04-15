package com.coredata.myapplication.repository

import com.coredata.myapplication.api.UniversityApi
import com.coredata.myapplication.model.UniversityResponse
import javax.inject.Inject

class UniversityRepository @Inject constructor(
    private val universityApi: UniversityApi
) : IUniversityService {
    override suspend fun getUniversities(): List<UniversityResponse> {
        try {
            return universityApi.getUniversities()
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }
}