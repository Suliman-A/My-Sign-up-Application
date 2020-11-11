package com.example.mysignupapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPersonFirstName = findViewById<EditText>(R.id.editTextPersonFirstName)
        val editTextPersonLastName = findViewById<EditText>(R.id.editTextPersonLastName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val editTextPhone = findViewById<EditText>(R.id.editTextPhone)
        val nextPageButton = findViewById<Button>(R.id.nextPageButton)
        val switch1 = findViewById<Switch>(R.id.switch1)
        val progressAge = findViewById<TextView>(R.id.progressAge)
        editTextPhone.visibility = View.GONE


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                progressAge.text = "Age: $i"

            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext, "start tracking", Toast.LENGTH_SHORT).show()
            }
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                Toast.makeText(applicationContext, "stop tracking", Toast.LENGTH_SHORT).show()
            }
        })

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                editTextPhone.visibility = View.VISIBLE //making visible
            }else if (!isChecked){
                editTextPhone.visibility = View.GONE //making invisible
            }
        }

        nextPageButton.setOnClickListener {

            val fName = editTextPersonFirstName.text.toString()
            val lName = editTextPersonLastName.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()
            val progressAge = progressAge.text.toString()

            val intent = Intent(this@MainActivity,SecondActivity::class.java);

            intent.putExtra("Username", fName)
            intent.putExtra("UserLastName", lName)
            intent.putExtra("Email", email)
            intent.putExtra("Phone", phone)
            intent.putExtra("Age", progressAge)
            startActivity(intent);
        }



    }
}

