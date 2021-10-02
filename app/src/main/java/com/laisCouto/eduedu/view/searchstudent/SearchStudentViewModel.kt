package com.laisCouto.eduedu.view.searchstudent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laisCouto.eduedu.StudentModel
import com.laisCouto.eduedu.service.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchStudentViewModel : ViewModel() {
    private val repo = DatabaseRepository()
    private val state = MutableLiveData<SearchState>()
    private val resultField = mutableListOf<StudentModel>()

    fun observeState(): LiveData<SearchState> = state

    fun fetchStudents() {
        viewModelScope.launch(Dispatchers.Main){
            state.postValue(SearchState.Loading)
            try {
                val result = repo.fetchStudents()
                if (result != null) {
                    resultField.addAll(result)
                    handleSuccess(resultField)
                }
            } catch (e: Exception) {
                handleError()
            }
        }
    }

    private fun handleSuccess(list : List<StudentModel>){
        state.postValue(SearchState.Success(list))
    }

    private fun handleError(){
        state.postValue(SearchState.Error)

    }
}