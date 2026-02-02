package com.example.videocallapp.LiveStreamApp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.videocallapp.R
import com.example.videocallapp.databinding.ActivityMainOfLiveStreamBinding
import kotlin.random.Random

class MainOfLiveStream : AppCompatActivity() {
    lateinit var binding:ActivityMainOfLiveStreamBinding
    private var appId:Long=1900138748
        private var appsign = "abbb4255d9395d9ef8feff8e5ff79dc08c368f03d415515010c72a4821ad3966"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainOfLiveStreamBinding.inflate(layoutInflater)
        setContentView(binding.root)
 var userId :String = generateuserid()
        val userName = userId + "user"
        val liveId = "test_id"

        binding.textView5.setOnClickListener{
            val intent = Intent(this,LiveActivity::class.java)
            intent.putExtra("host",true)
            intent.putExtra("appID",appId)
            intent.putExtra("appSign",appsign)
            intent.putExtra("userid",userId)
            intent.putExtra("liveid",liveId)
            startActivity(intent)
        }
        binding.textView6.setOnClickListener{
            val intent = Intent(this,LiveActivity::class.java)
            intent.putExtra("appID",appId)
            intent.putExtra("appSign",appsign)
            intent.putExtra("userid",userId)
            intent.putExtra("liveid",liveId)
            startActivity(intent)
        }
    }
    private  fun generateuserid():String{
        var builder = StringBuilder()
        val random = Random
        while (builder.length<5){
            val nextint = random.nextInt(10)
            if (builder.length==0 && nextint==0){
                continue
            }
            builder.append(nextint)
        }
        return  builder.toString()
    }
}