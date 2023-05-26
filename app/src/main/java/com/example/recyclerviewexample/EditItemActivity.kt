package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.recyclerviewexample.databinding.ActivityEditItemBinding

class EditItemActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditItemBinding
    private val  imageIdList = listOf(R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5)
    private  var indexImage = 0
    private  var imageId = R.drawable.item1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Back to Home"
        initButton()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
            R.id.save -> {
                binding.apply {
                    val item = Item(imageId, edTitle.text.toString(), edDescription.text.toString())
                    val editIntent = Intent().apply {
                        putExtra("item", item)
                    }
                    setResult(RESULT_OK,editIntent)
                    finish()
                }

            }
            R.id.sync ->{

            }
            R.id.search ->{

            }
        }
        return true
    }

    private fun initButton() = with(binding){
        bNext.setOnClickListener {
            indexImage ++
            if (indexImage > imageIdList.size - 1) indexImage = 0
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener{
            val item = Item(imageId, edTitle.text.toString(), edDescription.text.toString())
            val editIntent = Intent().apply {
                putExtra("item", item)
            }
            setResult(RESULT_OK,editIntent)
            finish()
        }
    }

}