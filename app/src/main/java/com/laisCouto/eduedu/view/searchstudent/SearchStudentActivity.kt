package com.laisCouto.eduedu.view.searchstudent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.laisCouto.eduedu.R
import com.laisCouto.eduedu.StudentModel
import com.laisCouto.eduedu.view.adapter.StudantAdapter
import com.laisCouto.eduedu.view.addstudent.AddStudentActivity

class SearchStudentActivity : AppCompatActivity() {

    private val viewModel = SearchStudentViewModel()
    private val adapter = StudantAdapter()
    private var orderByName = false
    private var orderByGrade = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_student)

        viewModel.fetchStudents()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        observeFactsViewModel()
        addStudent()
    }

    private fun handlerSuccess(listField: List<StudentModel>) {
        adapter.updateField(listField)
    }

    private fun observeFactsViewModel() {
        viewModel.observeState().observe(this, {
            when (it) {
                is SearchState.Loading -> {
                    Toast.makeText(this, "LOADING", Toast.LENGTH_SHORT).show()
                }

                is SearchState.Success -> {
                    handlerSuccess(it.list)
                }
                is SearchState.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun addStudent(){
        val setupAdd = findViewById<FloatingActionButton>(R.id.floating)
        setupAdd.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }


}