package com.laisCouto.eduedu.view.login

sealed class LoginAuthenticationState{
    object Loading: LoginAuthenticationState()
    data class Success(val fields: MutableList<List<Pair<String, String>>>): LoginAuthenticationState()
    object  Error:LoginAuthenticationState()

}
