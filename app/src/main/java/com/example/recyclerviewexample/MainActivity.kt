package com.example.recyclerviewexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val adapter = ItemAdapter()
    private var launcherEditScreen: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        bottomNav()
        binding.bNav.selectedItemId = R.id.edititemview
        launcherEditScreen = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                adapter.addItem(it.data?.getSerializableExtra("item") as Item)
            }
        }
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener{
                launcherEditScreen?.launch(Intent(this@MainActivity, EditItemActivity::class.java))
            }
        }
    }

    private  fun bottomNav() {
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item2 ->{
                    Toast.makeText(this, "Item", Toast.LENGTH_SHORT)
                }
                R.id.edititemview ->{
                    launcherEditScreen?.launch(Intent(this@MainActivity, EditItemActivity::class.java))
                }
            }
            true
        }
    }
}