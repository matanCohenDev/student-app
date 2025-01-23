package com.example.studentapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.R
import com.example.studentapp.models.Student

class StudentsRecyclerAdapter(
  private val students: List<Student>,
  private val onItemClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentsRecyclerAdapter.StudentViewHolder>() {

  class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.student_name)
    val idTextView: TextView = view.findViewById(R.id.student_id)
    val studentImageView: ImageView = view.findViewById(R.id.student_image)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_student_row_view, parent, false)
    return StudentViewHolder(view)
  }

  override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
    val student = students[position]
    holder.nameTextView.text = student.name
    holder.idTextView.text = student.id

    holder.itemView.setOnClickListener {
      onItemClick(student)
    }
  }

  override fun getItemCount(): Int = students.size
}
