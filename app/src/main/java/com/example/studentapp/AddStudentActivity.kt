package com.example.studentapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Add Student"


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