package com.example.studentapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapp.models.Student

class StudentEditArea : AppCompatActivity() {

  private var student: Student? = null
  private lateinit var nameEditText: EditText
  private lateinit var idEditText: EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_edit_area)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.title = "Edit Student"

    student = intent.getSerializableExtra("student") as? Student

    nameEditText = findViewById(R.id.edit_student_name)
    idEditText = findViewById(R.id.edit_student_id)
    val saveButton: Button = findViewById(R.id.save_student_button)

    student?.let {
      nameEditText.setText(it.name)
      idEditText.setText(it.id)
    }

    saveButton.setOnClickListener {
      saveAndFinish()
    }
  }

  // פונקציה משותפת ששומרת את העדכונים ומחזירה תוצאה
  private fun saveAndFinish() {
    student?.let {
      it.name = nameEditText.text.toString()
      it.id = idEditText.text.toString()

      val resultIntent = Intent()
      resultIntent.putExtra("updated_student", it)
      setResult(Activity.RESULT_OK, resultIntent)
    }
    finish()
  }

  // כאשר לוחצים על כפתור החץ בחלק העליון של ה־ActionBar
  override fun onSupportNavigateUp(): Boolean {
    saveAndFinish()
    return true
  }

  // כאשר לוחצים על כפתור החזרה של המכשיר
  override fun onBackPressed() {
      super.onBackPressed()
      saveAndFinish()
  }
}
