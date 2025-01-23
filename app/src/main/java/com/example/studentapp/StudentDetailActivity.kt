package com.example.studentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class StudentDetailActivity : AppCompatActivity() {
    companion object {
        private const val EDIT_STUDENT_REQUEST = 1
    }

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Student Details"

        val deleteBtn: Button = findViewById(R.id.delete_button)
        val editBtn: Button = findViewById(R.id.edit_button)

        student = intent.getSerializableExtra("student") as? Student

        deleteBtn.setOnClickListener {
            student?.let {
                Model.students.remove(it)
                finish()
            }
        }

        editBtn.setOnClickListener {
            student?.let {
                val intent = Intent(this, StudentEditArea::class.java)
                intent.putExtra("student", it)
                startActivityForResult(intent, EDIT_STUDENT_REQUEST)
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Student Details"

        updateStudentDetails()
    }

    private fun updateStudentDetails() {
        val nameTextView: TextView = findViewById(R.id.student_detail_name)
        val idTextView: TextView = findViewById(R.id.student_detail_id)

        student?.let {
            nameTextView.text = it.name
            idTextView.text = it.id
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_STUDENT_REQUEST && resultCode == Activity.RESULT_OK) {
            student = data?.getSerializableExtra("updated_student") as? Student
            updateStudentDetails()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}