package com.coredata.myapplication.usecase

import com.coredata.myapplication.database.University
import com.coredata.myapplication.listConverter.Converter.toUniversityList
import com.coredata.myapplication.model.UniversityResponse
import com.coredata.myapplication.repository.UniversityRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UniversityUseCase @Inject constructor(private val repository: UniversityRepository) {

    suspend fun getUniversityListFromSever(): Result<List<UniversityResponse>> = coroutineScope {
        return@coroutineScope try {
            val universityList = repository.getUniversities()
            Result.success(universityList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}