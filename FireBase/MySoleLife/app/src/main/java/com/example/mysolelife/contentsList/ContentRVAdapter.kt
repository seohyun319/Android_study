package com.example.mysolelife.contentsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mysolelife.R

class ContentRVAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<ContentRVAdapter.Viewholder>() {
    // 아이템 하나(content_rv_item.xml) 갖고와서 하나의 레이아웃 만들어줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentRVAdapter.Viewholder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item, parent, false)
        return Viewholder(v)
    }

    // 바인드해와서 아이템 연결
    override fun onBindViewHolder(holder: ContentRVAdapter.Viewholder, position: Int) {
        holder.bindItems(items[position])
    }

    // 아이템의 개수가 몇 개인지
    override fun getItemCount(): Int {
        return items.size
    }

    // content_rv_item.xml에 하나하나씩 리턴 넣어주는 역할. 아이템의 내용물 넣어주기
    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: String) {

        }
    }

}