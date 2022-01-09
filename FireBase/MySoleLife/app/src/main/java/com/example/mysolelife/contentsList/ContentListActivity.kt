package com.example.mysolelife.contentsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysolelife.R

class ContentListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        // -------------------------------------------------------------------------------------------------
        // ContentListActivity ⊃ ContentRVAdapter
        // ContentListActivity 안에 ContentRVAdapter의 아이템이 RecyclerView로 보여짐

        // 동작 원리:
        // Activity에서 아이템들을 Adapter로 넘겨줘서
        //      (: ContentListActivity.kt에서 items.add로 넣은 아이템들을 `rvAdapter = ContentRVAdapter(items)`로 ContentRVAdapter에 넘겨줌)
        // Adapter에서 item.xml을 통해 하나하나씩 아이템을 넣어줌
        //      (: ContentRVAdapter.kt에서 onCreateViewHolder 부분. xml과 연결.)
        // 하나하나씩 넣은 아이템을 activity.xml에 있는 리사이클뷰에 넣어줌
        //      (: ContentListActivity.kt에서 `rv.adapter = rvAdapter`로 activity_content_list.xml에 있는 리사이클뷰와 연결)
        // -------------------------------------------------------------------------------------------------


        // RecyclerView 생성
        // activity_content_list.xml에 보면 RecyclerView id를 rv로 해놨음.
        val rv : RecyclerView = findViewById(R.id.rv)

        // ContentRVAdapter의 인자인 items 만들어주기
        val items = ArrayList<ContentModel>()
        items.add(ContentModel("imageUrl1", "title1"))
        items.add(ContentModel("imageUrl1", "title1"))
        items.add(ContentModel("imageUrl1", "title1"))


        // ContentRVAdapter 연결
        // 위에서 만든 items를 ContentRVAdapter에 인자로 넘겨줌
        val rvAdapter = ContentRVAdapter(items)
        // rv의 adapter는 여기에서 만든 rvAdapter(=ContentRVAdapter(items))이다~
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this, 2)
    }
}