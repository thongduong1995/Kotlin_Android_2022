package com.example.kotlinandroid2022.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinandroid2022.R
import com.example.kotlinandroid2022.data.MainItems

class MainAdapter(val dataSet: List<MainItems>) : RecyclerView.Adapter<MainAdapter.MyVierHolder>() {
    var orientation = LinearLayout.VERTICAL
    class MyVierHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.imageView_MainRecycler_Id)
        val name = view.findViewById<TextView>(R.id.text_mainRecycler_id)
        val linearLayout = view.findViewById<LinearLayout>(R.id.layout_Recyclerview_Main_Id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVierHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_items_main, parent, false)
        return MyVierHolder(v)
    }

    override fun onBindViewHolder(holder: MyVierHolder, position: Int) {
        holder.imageView.setImageResource(dataSet[position].image_id)
        holder.name.text = dataSet[position].name
        holder.linearLayout.orientation = orientation
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @JvmName("setOrientation1")
    fun setOrientation(ori: Int){
        orientation =  ori
    }
}