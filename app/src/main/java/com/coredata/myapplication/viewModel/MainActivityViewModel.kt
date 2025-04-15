package com.coredata.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coredata.myapplication.state.UiState
import com.coredata.myapplication.usecase.UniversityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val universityUseCase: UniversityUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    internal val uiState  = _uiState.asStateFlow()

    init {
        getUniversityList()
    }

    private fun getUniversityList() {
        viewModelScope.launch {
            _uiState.value = UiState(
                isLoading = true,
            )

            universityUseCase.getUniversityListFromSever()
                .onSuccess { universityList ->
                    _uiState.value = UiState(
                        isLoading = false,
                        universityList = universityList,
                        isSuccess = true
                    )
                }
                .onFailure { exception ->
                    Log.e("TAG", "Error fetching university list: ${exception.message}")
                    _uiState.value = UiState(
                        isLoading = false,
                        error = exception.message,
                        isError = true
                    )
                }
        }
    }
}