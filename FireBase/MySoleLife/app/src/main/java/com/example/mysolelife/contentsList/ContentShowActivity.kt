package com.example.mysolelife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.example.mysolelife.R

class ContentShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_show)

        // ContentListActivity에서 넘어온 url을 받아줌.
        val getUrl = intent.getStringExtra("url")

        // 웹뷰로 엶 -> 유저의 인터넷 새창으로 열림
        val webView : WebView = findViewById(R.id.webView)
        // 웹뷰에 받아온 url을 넣어줌
        webView.loadUrl(getUrl.toString())
    }
}