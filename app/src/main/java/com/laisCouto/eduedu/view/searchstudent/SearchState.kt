package com.laisCouto.eduedu.view.searchstudent

import com.laisCouto.eduedu.StudentModel


sealed class SearchState{
    object Loading: SearchState()
    data class Success(val list: List<StudentModel>): SearchState()
    object  Error: SearchState()
}