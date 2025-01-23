package com.example.studentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.adapters.StudentsRecyclerAdapter
import com.example.studentapp.models.Model

class StudentListActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_student_list)

    val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
    val addButton: Button = findViewById(R.id.add_student_button)

    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = StudentsRecyclerAdapter(Model.students) { student ->
      val intent = Intent(this, StudentDetailActivity::class.java)
      intent.putExtra("student", student)
      startActivity(intent)
    }

    addButton.setOnClickListener {
      val intent = Intent(this, AddStudentActivity::class.java)
      startActivity(intent)
    }
  }

  override fun onResume() {
    super.onResume()
    val recyclerView: RecyclerView = findViewById(R.id.students_recycler_view)
    recyclerView.adapter?.notifyDataSetChanged()
  }
}
