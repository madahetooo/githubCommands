package com.apps.githubcomannds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apps.githubcomannds.databinding.ActivityCoroutineExampleBinding
import kotlinx.coroutines.*

class CoroutineExample : AppCompatActivity() {

    val TAG = "CoroutineExample"


    private lateinit var binding: ActivityCoroutineExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineExampleBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch(Dispatchers.Default) {
            delay(5000) // WAIT 5 SECONDS
            Log.d(TAG, "This is coroutine Thread")

            //Switch the context to be MAIN context
            withContext(Dispatchers.Main){
                binding.txUpdatedText.text = "Updated Text"
            }
        }
        Log.d(TAG, "This is Main Thread")
    }
}