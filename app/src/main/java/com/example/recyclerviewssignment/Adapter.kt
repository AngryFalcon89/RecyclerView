package com.example.recyclerviewssignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewssignment.databinding.SingleItemBinding

//step1: Create adapter class
//step3: inherit from RecyclerView.adapter and pass Adapter.ViewHolder as generic type
//step4: implement member functions
class Adapter(var dataList: ArrayList<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    //step2: create custom ViewHolder class and inherit from RecyclerView.ViewHolder by passing root XML as a constructor
    inner class ViewHolder (var binding : SingleItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //step5: design file and Model files are combined in onCreateView function
        //we say that ViewHolder class will get SingleItemBinding and will inflate it in root file
        //but we have not created its object that is further getting attached to binding.root
        //normal XML gayi -> ViewHolder return hua
        var binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    //size of recyclerView shown is decided in this function
    override fun getItemCount(): Int {
        return dataList.size  //size = dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //step6: set the data in the inflated recyclerViewList
        holder.binding.videoThumbnail.setImageResource(dataList.get(position).videoThumbnail)
        holder.binding.channelThumbnail.setImageResource(dataList.get(position).channelThumbnail)
        holder.binding.videoTitle.text = dataList.get(position).videoTitle
    }

}