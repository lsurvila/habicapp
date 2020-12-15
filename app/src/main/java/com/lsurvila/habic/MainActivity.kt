package com.lsurvila.habic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.lsurvila.habic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.habicListView.layoutManager = LinearLayoutManager(this)
        binding.habicListView.adapter = HabicAdapter(arrayOf("Gym", "Emails", "Work", "Study"))
    }
}