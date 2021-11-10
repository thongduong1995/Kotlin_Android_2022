package com.example.kotlinandroid2022

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinandroid2022.activities.DetailExplicitIntentActivity
import com.example.kotlinandroid2022.activities.DetailFragmentActivity
import com.example.kotlinandroid2022.activities.DetailImplicitIntent
import com.example.kotlinandroid2022.activities.DetailWidgetsActivity
import com.example.kotlinandroid2022.adapter.MainAdapter
import com.example.kotlinandroid2022.constant.MainItemType
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
        val toolbar = findViewById<View>(R.id.main_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val recyclerView = binding.recyclerViewMainId
        resources
        lists = respository.fetchData(resources)
        myAdapter = MainAdapter(lists)


        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val decoreate = DividerItemDecoration(this, mLayoutManager.orientation)
        recyclerView.apply {
            adapter = myAdapter
            layoutManager = mLayoutManager
            setHasFixedSize(true)
        }

        //decoreate
//        ContextCompat.getDrawable(applicationContext, R.drawable.main_space_recyclerview_item)
//            ?.let { decoreate.setDrawable(it) }
        //recyclerView.addItemDecoration(decoreate)


//        binding.imageButton.setOnClickListener {
//            if (isLinear) {
//                recyclerView.layoutManager = GridLayoutManager(this, 2)
//                myAdapter.setOrientation(LinearLayout.VERTICAL)
//                isLinear = false
//               // binding.imageButton.setImageResource(R.drawable.grid_layout_main)
//                binding.imageButton.setImageResource(R.drawable.grid_layout_main)
//                binding.imageButton.scaleType = ImageView.ScaleType.FIT_CENTER
//            } else {
//                recyclerView.layoutManager = LinearLayoutManager(this)
//                myAdapter.setOrientation(LinearLayout.HORIZONTAL)
//                binding.imageButton.setImageResource(R.drawable.linear_layout_main)
//                binding.imageButton.scaleType = ImageView.ScaleType.FIT_CENTER
//                isLinear = true;
//            }
        // }

        onItemClickListener()
        // myAdapter.notifyDataSetChanged()
    }

    private fun onItemClickListener() {
        myAdapter.setOnclickListener {
            when (it.item_type) {
                MainItemType.MAIN_ITEM_WIDGETS ->{
                    startActivity(Intent(this, DetailWidgetsActivity::class.java))
                }

                MainItemType.MAIN_ITEM_EXPLICIT_INTENT -> {
                    startActivity(Intent(this, DetailExplicitIntentActivity::class.java))
                }

                MainItemType.MAIN_ITEM_IMPLICIT_INTENT -> {
                    startActivity(Intent(this, DetailImplicitIntent::class.java))
                }

                MainItemType.MAIN_ITEM_FRAGMENT -> {
                    startActivity(Intent(this, DetailFragmentActivity::class.java))
                }

            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.image_button -> {
            if (isLinear) {
                binding.recyclerViewMainId.layoutManager = GridLayoutManager(this, 2)
                myAdapter.setOrientation(LinearLayout.VERTICAL)
                item.icon = getDrawable(R.drawable.grid_icon_24)
                isLinear = false;
            } else {
                binding.recyclerViewMainId.layoutManager = LinearLayoutManager(this)
                myAdapter.setOrientation(LinearLayout.HORIZONTAL)
                // R.id.image_button.setImageResource(R.drawable.linear_layout_main)
                item.icon = getDrawable(R.drawable.linear_icon_24)
                isLinear = true
            }
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}