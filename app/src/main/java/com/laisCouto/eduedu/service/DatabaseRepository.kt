package com.laisCouto.eduedu.service


import com.laisCouto.eduedu.StudentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepository {
    private val firebaseService = FirebaseService()

    suspend fun singIn(email:String, password: String): Boolean {
         return withContext(Dispatchers.IO){
            firebaseService.signIn(email, password)
         }
    }
    suspend fun fetchStudents(): List<StudentModel>? {
        return withContext(Dispatchers.IO){
            firebaseService.fetchStudents()
        }
    }



}