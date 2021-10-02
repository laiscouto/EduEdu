package com.laisCouto.eduedu

import com.google.firebase.auth.FirebaseUser

data class AuthenticationModel(
    var userId: FirebaseUser?,
    var success: Boolean
)