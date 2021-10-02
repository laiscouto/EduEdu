package com.laisCouto.eduedu.view.login

sealed class LoginAuthenticationState{
    object Loading: LoginAuthenticationState()
    object Success: LoginAuthenticationState()
    object  Error:LoginAuthenticationState()

}
