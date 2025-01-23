package com.example.studentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.models.Model
import com.example.studentapp.models.Student

class StudentEditArea : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.student_edit_area)

    // הפעלת כפתור חזרה (אם יש ActionBar נתמך)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.title = "Edit Student"

    val student = intent.getSerializableExtra("student") as? Student

    val nameEditText: EditText = findViewById(R.id.edit_student_name)
    val idEditText: EditText = findViewById(R.id.edit_student_id)
    val saveButton: Button = findViewById(R.id.save_student_button)

    student?.let {
      nameEditText.setText(it.name)
      idEditText.setText(it.id)
    }

    saveButton.setOnClickListener {
      student?.let {
        it.name = nameEditText.text.toString()
        it.id = idEditText.text.toString()

        val resultIntent = Intent()
        resultIntent.putExtra("updated_student", it)
        setResult(Activity.RESULT_OK, resultIntent)

        finish()
      }
    }
  }

  // הפעלת כפתור ה-Back המובנה של המובייל
  override fun onBackPressed() {
    super.onBackPressed()
    finish()
  }

  // הפעלת כפתור החץ חזרה המובנה (ActionBar)
  override fun onSupportNavigateUp(): Boolean {
    finish()
    return true
  }
}
