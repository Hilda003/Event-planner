package com.example.eventplanner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventplanner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    private lateinit var binding: ActivityMainBinding
    private val event = ArrayList<Event>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.rvEvent.setHasFixedSize(true)
        event.addAll(getEvent())
        showRecyclerList()

    }

    private fun getEvent(): ArrayList<Event>{
        val dataName = resources.getStringArray(R.array.event_title)
        val dataDate = resources.getStringArray(R.array.event_date)
        val dataLocation = resources.getStringArray(R.array.event_location)
        val dataImage = resources.obtainTypedArray(R.array.event_image)
        event.clear()
        for (i in dataName.indices) {
            event.add(
                Event(
                    dataName[i],
                    dataDate[i],
                    dataLocation[i],
                    dataImage.getResourceId(i, -1)
                )
            )
        }
        dataImage.recycle()
        return event
    }


    private fun showRecyclerList() {
        binding.rvEvent.layoutManager = LinearLayoutManager(this)
        val listEventAdapter = ListEventAdapter(event)
        binding.rvEvent.adapter = listEventAdapter
    }
}