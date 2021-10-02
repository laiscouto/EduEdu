package com.laisCouto.eduedu

import android.net.UrlQuerySanitizer

// todo:remover inicialização de variavéis
data class StudentModel(
    val name: String? = "",
    val grade: Int? = 0,
    var imgUrl : String? =""
)