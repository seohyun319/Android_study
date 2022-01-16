package com.example.mysolelife.utils

import com.google.firebase.auth.FirebaseAuth

// currentUser의 uid 받아오려면 동일한 코드 항상 쳐야하니까 함수로 만들어줌
// (원래는 SplashActivity.kt에 들어있는 코드)
class FBAuth {
    companion object {
        private lateinit var auth: FirebaseAuth

        fun getUid(): String {
            auth = FirebaseAuth.getInstance()
            return auth.currentUser?.uid.toString()
        }
    }
}