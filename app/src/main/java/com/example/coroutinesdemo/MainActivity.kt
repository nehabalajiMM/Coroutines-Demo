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
        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(tag, "Starting long running calculation")
            withTimeout(2000L) {
                for (i in 30..42) {
                    if (isActive) {
                        Log.d(tag, "Result for i = $i: ${fib(i)}")
                    }
                }
            }
            Log.d(tag, "Ending long running calculation")
        }

//        runBlocking {
//            delay(1000L)
//            job.cancel()
//            Log.d(tag, "Main thread is continuing..")
//        }
    }

    fun fib(n: Int): Long {
        return if (n==0) 0
        else if (n==1) 1
        else fib(n-1)+fib(n-2)
    }
}