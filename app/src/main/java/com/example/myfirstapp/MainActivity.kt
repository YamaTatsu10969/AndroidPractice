package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var tapFlag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 制約をつけてくれているみたい

        tapHere.setOnClickListener {
            textView2.text = "ボタンがタップされました！！！"
            imageView.isVisible = tapFlag
            imageView3.isVisible = !tapFlag
            if (tapFlag) {
                print(tapFlag)

                textView2.text = "また押して〜"
            }
            tapFlag = !tapFlag
        }

    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View) {
        // Get the text view // findViewById は処理コストが高い。
        val showCountTextView = findViewById<TextView>(R.id.textView)

        // Get the value of the text view
        val countString = showCountTextView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count++

        // Display the new value in the text view
        showCountTextView.text = count.toString()
    }

    fun randomMe(view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the text view
        val textView = findViewById<TextView>(R.id.textView)

        // Get the current value of the text view.
        val countString = textView.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }
}

