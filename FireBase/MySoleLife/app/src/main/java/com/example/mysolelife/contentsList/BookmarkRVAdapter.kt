package com.example.mysolelife.contentsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mysolelife.R

class BookmarkRVAdapter (val context : Context, val items: ArrayList<ContentModel>, val keyList: ArrayList<String>, val bookmarkIdList: MutableList<String>)
    : RecyclerView.Adapter<BookmarkRVAdapter.Viewholder>() {

    // 아이템 하나(content_rv_item.xml) 갖고와서 하나의 레이아웃 만들어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        Log.d("contentrvadapter", keyList.toString())
        Log.d("contentrvadapter", bookmarkIdList.toString())
        return Viewholder(v)
    }

    // 바인드해와서 아이템 연결
    override fun onBindViewHolder(holder: BookmarkRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position], keyList[position])
    }

    // 아이템의 개수가 몇 개인지
    override fun getItemCount(): Int {
        return items.size
    }

    // content_rv_item.xml에 하나하나씩 리턴 넣어주는 역할. 아이템의 내용물 넣어주기
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ContentModel, key: String) {
            itemView.setOnClickListener {
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", item.webUrl)
                itemView.context.startActivity(intent)
            }
            // itemView = content_rv_item.xml임. (위에서 연결해줬음.)
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)
            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)
            val bookmarkArea = itemView.findViewById<ImageView>(R.id.bookmarkArea)

            if (bookmarkIdList.contains(key)) {
                bookmarkArea.setImageResource(R.drawable.bookmark_color)
            } else {
                bookmarkArea.setImageResource(R.drawable.bookmark_white)
            }

            // item은 `val items: ArrayList<ContentModel>`로 받아온 items의 각각 하나의 아이템
            contentTitle.text = item.title

            Glide.with(context)
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }
}