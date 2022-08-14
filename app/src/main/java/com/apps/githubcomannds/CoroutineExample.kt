package com.apps.githubcomannds

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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

        GlobalScope.launch (Dispatchers.IO){
            val result1 = async { doNetworkCall1() }
            val result2 = async { doNetworkCall2() }
            Log.d(TAG,"Result 1 is equal to :  ${result1.await()}")
            Log.d(TAG,"Result 2 is equal to :  ${result2.await()}")
        }
    }

    suspend fun doNetworkCall1() :String{
        delay(5000)
        return "Network Call Result 1"
    }
    suspend fun doNetworkCall2() :String{
        delay(5000)
        return "Network Call Result 2"
    }
}