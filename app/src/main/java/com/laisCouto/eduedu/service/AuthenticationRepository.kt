package com.laisCouto.eduedu.service

import com.laisCouto.eduedu.AuthenticationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthenticationRepository {
    private val firebaseService = FirebaseService()

    suspend fun singIn(email:String, password: String): AuthenticationModel{
         return withContext(Dispatchers.IO){
            firebaseService.signIn(email, password)
         }
    }

}