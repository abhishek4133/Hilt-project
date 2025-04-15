package com.coredata.myapplication.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {
//    @Query("SELECT * FROM university ORDER BY name ASC")
//    fun getAllUniversities(): Flow<List<University>>
//
//    @Query("SELECT * FROM university WHERE name = :name")
//    fun getUniversitiesById(name: String): Flow<List<University>>
//
//    @Upsert
//    suspend fun insertUniversities(universities: List<University>)

//    @Query("DELETE FROM university")
//    suspend fun deleteAllUniversities() : Int
}