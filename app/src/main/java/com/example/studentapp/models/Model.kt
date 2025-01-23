package com.example.studentapp.models

object Model {
  val students: MutableList<Student> = mutableListOf(
    Student(name = "John Doe", id = "123456", isChecked = false),
    Student(name = "Jane Smith", id = "654321", isChecked = true),
    Student(name = "Michael Brown", id = "111222", isChecked = false)
  )
}
