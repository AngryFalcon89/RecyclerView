package com.example.recyclerviewssignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewssignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ActivityMainBinding is inflated i.e. design having RecyclerView is inflated
        //
        //inflate(layoutInflater): This method is used to inflate (create) an instance of the ActivityMainBinding class.
        // In Android, "inflating" typically refers to the process of converting an XML layout into actual View objects that
        // can be used within your activity.
        //
        //layoutInflater: This is an instance of the LayoutInflater class,
        // which is used to create View objects from XML layout resources.
        // It's a crucial part of the Android framework that allows you to turn XML layouts into actual UI components.

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        var dataList = ArrayList<Model>()
        dataList.add(Model(R.drawable.image0,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image1,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image2,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image3,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image4,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image5,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image1,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image7,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image8,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
        dataList.add(Model(R.drawable.image9,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))

        var adapter = Adapter(dataList)
        binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        binding.rv.adapter = adapter
    }
}