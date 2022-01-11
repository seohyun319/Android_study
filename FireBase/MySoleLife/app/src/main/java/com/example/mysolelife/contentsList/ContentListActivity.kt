package com.example.mysolelife.contentsList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysolelife.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ContentListActivity : AppCompatActivity() {

    // lateinit: 타입만 정해놓고 값은 나중에 넣겠다
    lateinit var myRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_list)

        // ContentRVAdapter의 인자인 items 만들어주기
        val items = ArrayList<ContentModel>()
        // ContentRVAdapter 연결
        // 위에서 만든 items를 ContentRVAdapter에 인자로 넘겨줌
        val rvAdapter = ContentRVAdapter(baseContext, items)


        // Firebase Realtime Database
        // Write a message to the database
        val database = Firebase.database

        val category = intent.getStringExtra("category")

        if(category == "category1") {
            myRef = database.getReference("contents")
        } else if(category == "category2") {
            myRef = database.getReference("contents2")
        }

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // 데이터 하나하나 빼오기
                // 데이터스냅샷에서 데이터 모델 가져옴
                for (dataModel in dataSnapshot.children) {
                    Log.d("ContentListActivity", dataModel.toString())
                    val item = dataModel.getValue(ContentModel::class.java)
                    items.add(item!!)
                }
                // 비동기라서 아이템 내용 받아오는 도중에 밑에 있는 리사이클러뷰 만들어짐. 리사이클러뷰 만들어진 후에 데이터가 불러와져서 이미 만들어진 리사이클러뷰에 들어가지 않음.
                // 그니까 데이터 다 받아오면 어뎁터를 refresh, 동기화해줘라.
                rvAdapter.notifyDataSetChanged()
                Log.d("ContentListActivity", items.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)




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

        // rv의 adapter는 여기에서 만든 rvAdapter(=ContentRVAdapter(items))이다~
        rv.adapter = rvAdapter

        rv.layoutManager = GridLayoutManager(this, 2)

    }
}