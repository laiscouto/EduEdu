package com.laisCouto.eduedu.service

import com.google.firebase.auth.FirebaseAuth
import com.laisCouto.eduedu.AuthenticationModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.coroutines.suspendCoroutine

class FirebaseService {

    private lateinit var  auth : FirebaseAuth

     /*suspend  fun signIn(email: String, password: String): AuthenticationModel {
        auth = Firebase.auth
         return suspendCoroutine { continuation ->
             var authenticationModel = AuthenticationModel(userId = null, success = false)
             auth.signInWithEmailAndPassword(email, password).continueWith { task ->
                 authenticationModel = AuthenticationModel(userId = auth.currentUser,
                     success = task.isSuccessful)
             }
             continuation.resumeWith(Result.success(authenticationModel))
         }
    }*/

    suspend fun signIn(email: String, password: String): AuthenticationModel {

        return withContext(Dispatchers.IO) {
            val auth = Firebase.auth
            val data = auth.signInWithEmailAndPassword(email, password)

            return@withContext AuthenticationModel(data.result?.user, data.result?.user != null)
        }
    }
}
