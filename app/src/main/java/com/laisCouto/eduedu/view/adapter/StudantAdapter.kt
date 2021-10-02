package com.laisCouto.eduedu.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laisCouto.eduedu.R
import com.laisCouto.eduedu.StudentModel

class StudantAdapter(): RecyclerView.Adapter<StudantViewHolder>() {

    private var field: List<StudentModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudantViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.form_recyler, parent,false)
        return StudantViewHolder(item)
    }

    override fun onBindViewHolder(holder: StudantViewHolder, position: Int) {
        holder.bind(field[position])
    }

    override fun getItemCount(): Int {
        println("--------------------------------------${field.count()}")
        return field.count()
    }

    fun  updateField(list: List<StudentModel>){
        field = list
        println("--------------------------------------${list}")
        notifyDataSetChanged()
    }
}