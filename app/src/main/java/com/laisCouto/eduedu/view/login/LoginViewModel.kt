package com.laisCouto.eduedu.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laisCouto.eduedu.service.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel: ViewModel() {
    private val repo = DatabaseRepository()
    private val state = MutableLiveData<AddState>()
    private val resultField = mutableListOf<List<Pair<String, String>>>()

    fun observeState(): LiveData<AddState> = state

    fun authetication(email: String, password: String){
        viewModelScope.launch(Dispatchers.Main){
            state.postValue(AddState.Loading)
            try {
                val result = repo.singIn(email, password)
                if (result) {
                    handleSuccess()
                } else {
                    handleError()
                }
            } catch (e: Exception) {
                handleError()
            }
        }
    }

    private fun handleSuccess(){
        state.postValue(AddState.Success)
    }

    private fun handleError(){
        state.postValue(AddState.Error)

    }
}