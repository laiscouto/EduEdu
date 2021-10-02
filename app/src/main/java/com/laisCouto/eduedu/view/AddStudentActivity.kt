package com.laisCouto.eduedu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.laisCouto.eduedu.R

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.add_toolbar)
        setSupportActionBar(toolbar)
    }
}