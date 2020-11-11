package com.example.mysignupapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        var intent = intent
        val fName = intent.getStringExtra("Username")
        val lName = intent.getStringExtra("UserLastName")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone")
        val age = intent.getStringExtra("Age")
        val date = intent.getStringExtra("Birthday")

        val resultTV = findViewById<TextView>(R.id.resultTV)

        resultTV.text =
            "First Name: $fName\nLast Name: $lName\nEmail: $email\nPhone: $phone\nAge: $age\nBirthday: $date"

    }
}