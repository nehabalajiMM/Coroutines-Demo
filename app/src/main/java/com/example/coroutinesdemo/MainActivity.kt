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

        Log.d(tag, "Before runblocking")
        runBlocking {
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(tag, "Finished IO coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(tag, "Finished IO coroutine 2")
            }
            Log.d(tag, "start of runblocking")
            delay(5000L)
            Log.d(tag, "End of runblocking")
        }
        Log.d(tag, "After runblocking")
    }


    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }
}