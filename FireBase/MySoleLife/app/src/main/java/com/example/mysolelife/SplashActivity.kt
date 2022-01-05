package com.example.mysolelife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mysolelife.auth.IntroActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = Firebase.auth


        if(auth.currentUser?.uid == null) { //auth.currentUser?.uid가 비었다면. 로그인 안 한 사람이라면.
            // splash 3초(3000) 후에 끝내고 intro로 연결
            Handler().postDelayed({
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }, 3000)
        } else { //auth.currentUser.uid 현재 유저의 uid가 있다면. 로그인했던 사람이라면.
            // splash 3초(3000) 후에 끝내고 main으로 연결
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)
        }

    }
}