package com.example.eventplanner

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventplanner.databinding.ItemRowEventBinding

class ListEventAdapter(private val listEvent: ArrayList<Event>): RecyclerView.Adapter<ListEventAdapter.ViewHolder>() {


    class ViewHolder(var binding: ItemRowEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRowEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, date, location, image) = listEvent[position]
        holder.binding.EventTitle.text = name
        holder.binding.EventDate.text = date
        holder.binding.EventLocation.text = location
        holder.binding.imageView.setImageResource(image)
        holder.itemView.setOnClickListener {
                        val intent = Intent(holder.itemView.context, DetailActivity::class.java)
//            intent.putExtra(DetailActivity.EXTRA_EVENT, listEvent[position])
        }

    }
}