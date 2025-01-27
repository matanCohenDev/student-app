package com.example.studentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class StudentDetailActivity : AppCompatActivity() {
    private var originalId: String? = null

    companion object {
        private const val EDIT_STUDENT_REQUEST = 1
    }

    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Student Details"

        val deleteBtn: Button = findViewById(R.id.delete_button)
        val editBtn: Button = findViewById(R.id.edit_button)

        student = intent.getSerializableExtra("student") as? Student
        originalId = student?.id


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
            val updatedStudent = data?.getSerializableExtra("updated_student") as? Student
            updatedStudent?.let { newStu ->
                val index = Model.students.indexOfFirst { it.id == originalId}
                if (index != -1) {
                    Model.students[index] = newStu
                }

                student = newStu
                originalId = newStu.id
                updateStudentDetails()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()  // או finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}