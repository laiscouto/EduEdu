package com.laisCouto.eduedu.view.login

sealed class AddState{
    object Loading: AddState()
    object Success: AddState()
    object Error: AddState()

}
