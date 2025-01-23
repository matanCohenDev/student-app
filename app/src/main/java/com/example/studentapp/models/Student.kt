package com.example.studentapp.models

import java.io.Serializable

data class Student(
  var name: String,
  var id: String,
  var isChecked: Boolean = false
) : Serializable
