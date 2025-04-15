package com.coredata.myapplication.state

import com.coredata.myapplication.model.UniversityResponse

data class UiState (
    var isLoading: Boolean = false,
    var error: String? = null,
    var universityList: List<UniversityResponse>? = null,
    var isError: Boolean = false,
    var isEmpty: Boolean = false,
    var isSuccess: Boolean = false
)