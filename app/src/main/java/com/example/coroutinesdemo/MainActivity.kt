package com.example.coroutinesdemo

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        GlobalScope.launch(Dispatchers.IO) {
            val networkCallAnswer = doNetworkCall()
            withContext(Dispatchers.Main) {
                textView.text = networkCallAnswer
            }
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
}