package com.laisCouto.eduedu.view.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laisCouto.eduedu.service.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel: ViewModel() {
    private val repo = AuthenticationRepository()
    private val state = MutableLiveData<LoginAuthenticationState>()
    private val resultField = mutableListOf<List<Pair<String, String>>>()

    fun observeState(): LiveData<LoginAuthenticationState> = state

    fun authetication(email: String, password: String){
        viewModelScope.launch(Dispatchers.Main){
            state.postValue(LoginAuthenticationState.Loading)
            try {
                val result = repo.singIn(email, password)
                if(result.success){
                    println("Sucessooooooooooooooooooooooooooooooooooooooooooooooo")
                    println( handleSuccess(resultField))
                }else{
                    println("Deu ruuuuuuuuuuuuuuuuuuuuuuuuuuim")
                    println(result)
                }
            } catch(e: Exception){
                println("==========${handleError()}")
            }
        }

    }

    private fun handleSuccess(list: MutableList<List<Pair<String, String>>>){
        state.postValue(LoginAuthenticationState.Success(list))
    }

    private fun handleError(){
        state.postValue(LoginAuthenticationState.Error)

    }
}