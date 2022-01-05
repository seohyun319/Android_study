package com.example.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mysolelife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

//        findViewById<Button>(R.id.logoutBtn).setOnClickListener{
//            auth.signOut()
//
//            //로그아웃하면 인트로 액티비티로 이동
//            val intent = Intent(this, IntroActivity::class.java)
//            // 기존에 쌓인 액티비티는 날려주겠다
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            startActivity(intent)
//        }
    }
}