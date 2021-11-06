package com.example.kotlinandroid2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinandroid2022.adapter.MainAdapter
import com.example.kotlinandroid2022.data.MainItems
import com.example.kotlinandroid2022.databinding.ActivityMainBinding
import com.example.kotlinandroid2022.respository.MainRespositoryList

class MainActivity : AppCompatActivity() {
     var respository: MainRespositoryList = MainRespositoryList()
    lateinit var myAdapter: MainAdapter
    lateinit var lists:List<MainItems>
    lateinit var binding: ActivityMainBinding
    var isLinear = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.recyclerViewMainId

        lists =respository.fetchData()
        myAdapter = MainAdapter(lists)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        binding.imageButton.setOnClickListener {
            if(isLinear){
                recyclerView.layoutManager = GridLayoutManager(this,3)
                myAdapter.setOrientation(LinearLayout.VERTICAL)
                isLinear = false
            } else{
                recyclerView.layoutManager = LinearLayoutManager(this)
                myAdapter.setOrientation(LinearLayout.HORIZONTAL)
                isLinear = true;
            }
        }
    }
}