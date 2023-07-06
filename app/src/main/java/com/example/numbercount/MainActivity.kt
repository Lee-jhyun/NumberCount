package com.example.numbercount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var numberTextView : TextView
    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberTextView = findViewById(R.id.number)

        findViewById<Button>(R.id.minus_button).setOnClickListener{
            number -= 1
            numberTextView.text = number.toString()
            if(number < 0){
                number = 0
                numberTextView.text = number.toString()
                Toast.makeText(this, "음수입니다!",Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.reset_button).setOnClickListener{
            number = 0
            numberTextView.text = number.toString()
        }

        findViewById<Button>(R.id.plus_button).setOnClickListener{
            number += 1
            numberTextView.text = number.toString()
        }

        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("number", number)
        outState.putString("numberText", numberTextView.text.toString())
        }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt("number")
        numberTextView.text = savedInstanceState.getString("numberText")
    }
    }