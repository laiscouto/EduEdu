package com.laisCouto.eduedu.view.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.laisCouto.eduedu.Constantes.Companion.KEYS_NAME
import com.laisCouto.eduedu.Constantes.Companion.KEY_IMG
import com.laisCouto.eduedu.R
import com.laisCouto.eduedu.StudentModel
import com.laisCouto.eduedu.view.addstudent.AddStudentActivity


class StudantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bind(studentModel: StudentModel) {

        val name = itemView.findViewById<TextView>(R.id.nome_studant)
        name.text = studentModel.name
        val ano = itemView.findViewById<TextView>(R.id.ano_card)
        ano.text = studentModel.grade.toString() + " º ano"
        val img = itemView.findViewById<ImageView>(R.id.img)


        if (studentModel.imgUrl !== "") {
            Glide.with(itemView)
                .load(studentModel.imgUrl)
                .into(img)
        }

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, AddStudentActivity::class.java).apply {
                val bundle = Bundle()
                bundle.putString(KEY_IMG, img.toString())
                bundle.putString(KEYS_NAME, name.toString())
                putExtras(bundle)
            }
            itemView.context.startActivity(intent)

        }



    }


}