package com.coredata.myapplication.listConverter

import com.coredata.myapplication.database.University
import com.coredata.myapplication.model.UniversityResponse

object Converter {
    fun UniversityResponse.toUniversity(): University {
        return University(
            stateProvince = this.stateProvince,
            country = this.country,
            webPages = this.webPages,
            name = this.name,
            alphaTwoCode = this.alphaTwoCode,
            domains = this.domains
        )
    }

    fun List<UniversityResponse>.toUniversityList(): List<University> {
        return this.map { it.toUniversity() }
    }
}