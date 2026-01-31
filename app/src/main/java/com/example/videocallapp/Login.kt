package com.example.videocallapp

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.videocallapp.databinding.ActivityLoginBinding
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

  binding.loginBtn.setOnClickListener { var myuserid = binding.editTextText.toString()
  if (myuserid.isNotEmpty()){
      var intent = Intent(this,MainActivity::class.java)
      intent.putExtra("userid","muuserid")
      startActivity(intent)
      setupzeouikit(myuserid)
  }
  }
    }

    private fun setupzeouikit(userid:String){
        val application :Application=getApplication()
        val appID :Long =1560554485
            val appsign:String ="d51d95a383c0b13afce50dc98a39ccbb7c88cc36434a1f04af8974465c35b01b"
        val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
        ZegoUIKitPrebuiltCallService.init(application,appID,appsign,userid,binding.editTextText.text.toString(),callInvitationConfig)

    }

    override fun onDestroy() {
        super.onDestroy()
        ZegoUIKitPrebuiltCallService.unInit()
    }
}