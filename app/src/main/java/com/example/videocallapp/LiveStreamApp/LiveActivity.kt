package com.example.videocallapp.LiveStreamApp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.videocallapp.R
import com.example.videocallapp.databinding.ActivityLiveBinding
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingConfig
import com.zegocloud.uikit.prebuilt.livestreaming.ZegoUIKitPrebuiltLiveStreamingFragment

class LiveActivity : AppCompatActivity() {
    lateinit var binding: ActivityLiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addFragment()


    }

    private  fun addFragment(){
        val appId = intent.getLongExtra("appID",0L)
        val appSign = intent.getStringExtra("appSign")
        val userId = intent.getStringExtra("userid")
        val liveId = intent.getStringExtra("liveid")
        val username = intent.getStringExtra("username")
        val host = intent.getBooleanExtra("host",false)
 val config = if(host){
     ZegoUIKitPrebuiltLiveStreamingConfig.host()
 }else{
     ZegoUIKitPrebuiltLiveStreamingConfig.audience()
 }

        val fragment = ZegoUIKitPrebuiltLiveStreamingFragment.newInstance(

            appId,
            appSign,
            userId,
            liveId,
            username,
            config,

        )
        supportFragmentManager.beginTransaction().replace(R.id.main,fragment).commit()

    }
}