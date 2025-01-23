package com.example.studentapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameEditText: EditText = findViewById(R.id.add_student_name)
        val idEditText: EditText = findViewById(R.id.add_student_id)
        val saveButton: Button = findViewById(R.id.save_student_button)

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val id = idEditText.text.toString()

            if (name.isNotBlank() && id.isNotBlank()) {
                Model.students.add(Student(name, id))
                finish()
            }
        }
    }
}