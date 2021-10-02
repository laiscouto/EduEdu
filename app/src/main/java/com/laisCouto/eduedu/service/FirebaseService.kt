package com.laisCouto.eduedu.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.laisCouto.eduedu.StudentModel
import kotlinx.coroutines.tasks.await
import java.lang.Exception


class FirebaseService {
    private val collectionName = "students"

    suspend fun signIn(email: String, password: String): Boolean {

        return try {
            val data = FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .await()

            (data.user != null)

        } catch (e: Exception) {
            false
        }
    }

    suspend fun fetchStudents(): List<StudentModel>? {
        try {

            val documentReference = Firebase.firestore
            val data = documentReference.collection(this.collectionName).get().await()
            val students = mutableListOf<StudentModel>()
            for (student in data.documents) {
                student.toObject(StudentModel::class.java)?.run {
                    if (this.imgUrl != "") this.imgUrl = this.imgUrl?.let { fetchImageUri(it) }
                    this.let { students.add(it) }
                }
            }
            return students
        } catch (e: Exception) {
            return null
        }
    }

    private suspend fun fetchImageUri(gsImageUrl: String): String? {
        return try {
            val storage = Firebase.storage("gs://eduedu-laiscouto.appspot.com")
            val task =  storage.getReferenceFromUrl(gsImageUrl)
                .downloadUrl
                .await()

            return task.toString()
        } catch (e: Exception) {
            null
        }
    }
}
