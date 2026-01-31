package com.example.videocallapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.videocallapp.databinding.ActivityMainBinding
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
val myUserid = intent.getStringExtra("userid")
        binding.textView3.text = "Hii $myUserid , \n Whom do you want to call?  "

        binding.textView3.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var targetuserid = binding.editTextText2.text.toString()
                if(targetuserid.isNotEmpty()){
                    startVideoCall(targetuserid)
                    startVoiceCall(targetuserid)
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        binding.voicecallbtn.setOnClickListener(View.OnClickListener {
            val targetUserID = binding.editTextText2.text.toString()
            if (targetUserID.isNotEmpty()) {
                startVoiceCall(targetUserID)
            }
        })

        binding.videocallbtn.setOnClickListener(View.OnClickListener {
            val targetUserID = binding.editTextText2.text.toString()
            if (targetUserID.isNotEmpty()) {
                startVideoCall(targetUserID)
            }
        })
    }
    private  fun startVideoCall(targetUseid:String){
        val targetUserName :String = targetUseid
        binding.videocallbtn.setIsVideoCall(true)
        binding.videocallbtn.setInvitees(listOf(ZegoUIKitUser(targetUseid,targetUserName)))
    }

    private  fun startVoiceCall(targetUseid:String){
        val targetUserName :String = targetUseid
        binding.voicecallbtn.setIsVideoCall(false)
        binding.voicecallbtn.setInvitees(listOf(ZegoUIKitUser(targetUseid,targetUserName)))
    }
}