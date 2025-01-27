package com.example.studentapp.models

object Model {
  val students: MutableList<Student> = mutableListOf(
    Student(name = "Roni Twito", id = "123456", isChecked = false),
    Student(name = "Matan Cohen", id = "654321", isChecked = true),
  )
}
