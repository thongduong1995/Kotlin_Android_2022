package com.example.kotlinandroid2022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinandroid2022.activities.DetailIntentActivity
import com.example.kotlinandroid2022.adapter.MainAdapter
import com.example.kotlinandroid2022.constant.MainItemsConst
import com.example.kotlinandroid2022.data.MainItems
import com.example.kotlinandroid2022.databinding.ActivityMainBinding
import com.example.kotlinandroid2022.respository.MainRespositoryList

class MainActivity : AppCompatActivity() {
    var respository: MainRespositoryList = MainRespositoryList()
    lateinit var myAdapter: MainAdapter
    lateinit var lists: List<MainItems>
    lateinit var binding: ActivityMainBinding
    var isLinear = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerViewMainId

        lists = respository.fetchData()
        myAdapter = MainAdapter(lists)
        recyclerView.adapter = myAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))


        binding.imageButton.setOnClickListener {
            if (isLinear) {
                recyclerView.layoutManager = GridLayoutManager(this, 3)
                myAdapter.setOrientation(LinearLayout.VERTICAL)
                isLinear = false
               // binding.imageButton.setImageResource(R.drawable.grid_layout_main)
                binding.imageButton.setImageResource(R.drawable.grid_layout_main)
                binding.imageButton.scaleType = ImageView.ScaleType.FIT_CENTER
            } else {
                recyclerView.layoutManager = LinearLayoutManager(this)
                myAdapter.setOrientation(LinearLayout.VERTICAL)
                binding.imageButton.setImageResource(R.drawable.linear_layout_main)
                binding.imageButton.scaleType = ImageView.ScaleType.FIT_CENTER
                isLinear = true;
            }
        }


        myAdapter.setOnclickListener{
            when(it.item_type){
                MainItemsConst.MAIN_ITEM_INTENT -> {
                    startActivity(Intent(this, DetailIntentActivity::class.java ))
                }
            }
        }
       // myAdapter.notifyDataSetChanged()
    }
}