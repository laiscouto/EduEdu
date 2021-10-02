package com.laisCouto.eduedu.service

import com.google.firebase.auth.FirebaseAuth
import com.laisCouto.eduedu.AuthenticationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.coroutines.suspendCoroutine

class FirebaseService {

    suspend fun signIn(email: String, password: String): AuthenticationModel {

        return try {
            val data = FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .await()

            return AuthenticationModel(data.user, data.user != null)
        } catch (e: Exception) {
            println(e.message + "<====================================================================")
            return AuthenticationModel(null, false)
        }
    }
}
