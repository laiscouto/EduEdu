package com.laisCouto.eduedu.view.addstudent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.laisCouto.eduedu.Constantes.Companion.KEYS_NAME
import com.laisCouto.eduedu.Constantes.Companion.KEY_IMG
import com.laisCouto.eduedu.R

class AddStudentActivity : AppCompatActivity() {

    private val img by lazy { intent.extras?.getString(KEY_IMG) }
    private val name by lazy { intent.extras?.getString(KEYS_NAME) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        /*val btnChangeImg = findViewById<Button>(R.id.change_img)
        btnChangeImg.setOnClickListener {
            registerForActivityResult(ActivityResultContracts.GetContent) { uri: Uri? ->
                if (uri.resultCode == Activity.RESULT_OK) {
                    val data = result.data

                    println(data.toString())
                }
            }
        }*/


    }
}