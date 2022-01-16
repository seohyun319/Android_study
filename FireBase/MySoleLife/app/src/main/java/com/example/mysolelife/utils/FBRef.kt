package com.example.mysolelife.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// Firebase에 db 넣으려면 동일한 코드 항상 쳐야하니까 함수로 만들어줌
// ContentListActivity
class FBRef {
    companion object {
        private val database = Firebase.database

        val category1 = database.getReference("contents")
        val category2 = database.getReference("contents2")

        val bookmarkRef = database.getReference("bookmark_list")

    }
}