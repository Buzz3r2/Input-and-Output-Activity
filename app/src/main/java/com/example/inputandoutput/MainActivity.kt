package com.example.inputandoutput

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Got the button using the id we set on the use interface.
        val clickMeButton = findViewById<Button>(R.id.clickMeButton)

        //Got the text view and edit text.
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTxt)
        val nameTxtField = findViewById<EditText>(R.id.nameEditTxt)

        //Added code to the button that happens when it is clicked.
        clickMeButton?.setOnClickListener {
            //Added code to the button that what is prompted when it is clicked.
            Toast.makeText(this@MainActivity, "Button clicked!",
                Toast.LENGTH_LONG).show()
            //Added code to greet the recipient.
            welcomeTextView.text = "Welcome ${nameTxtField.text}"
            //welcomeText.text = "Welcome " + nameTxtField.text

            //Added a switch to translate from English to Zulu
            val zuluSwitch = findViewById<Switch>(R.id.zuluSwitch)

            //Added additional code to the button
            clickMeButton?.setOnClickListener {}
            var greeting: String
            var zulu: Boolean = zuluSwitch.isChecked
            if (zulu) {
                greeting = "Sawubona, ${nameTxtField.text}!"
            } else {
                // Easter egg for Saadiq
                if (nameTxtField.text.toString() == "Saadiq" ||
                    nameTxtField.text.toString() == "Steyn") {
                    greeting = "Greetings, ${nameTxtField.text}!"
                } else {
                    greeting = "Hello, ${nameTxtField.text}!"
                }
            }
            welcomeTextView.text = greeting
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}