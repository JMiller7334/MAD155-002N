package com.example.savestateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.textservice.TextInfo
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInfo = findViewById<TextView>(R.id.textView)
        button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            textInfo.setText("I have been clicked!")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("savedText", findViewById<TextView>(R.id.textView).text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        textInfo.setText(savedInstanceState.getString("savedText"))
    }
}
