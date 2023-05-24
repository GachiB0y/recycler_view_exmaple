package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val adapter = ItemAdapter()
    private val  imageIdList = listOf(R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5)
    private var  index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                if (index > 4)index = 0
                val  item = Item(imageIdList[index],"Imeage $index")
                adapter.addItem(item)
                index++
            }
        }
    }
}