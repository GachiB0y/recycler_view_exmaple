package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.databinding.ItemBinding

class ItemAdapter:RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    val itemList = ArrayList<Item>()

    class ItemHolder(item:View):RecyclerView.ViewHolder(item){
        val  binding = ItemBinding.bind(item)
        fun bind(item: Item) = with(binding){
            im.setImageResource(item.imageId)
            tvTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
       return  itemList.size
    }

    fun addItem (item:Item){
        itemList.add(item)
        notifyDataSetChanged()
    }
}