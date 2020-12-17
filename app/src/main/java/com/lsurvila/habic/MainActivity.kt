package com.lsurvila.habic

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lsurvila.habic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val model: HabicViewModel by viewModels()
        model.getTodoItems().observe(this, { todoItems ->
            binding.habicListView.layoutManager = LinearLayoutManager(this)
            binding.habicListView.adapter = HabicAdapter(todoItems)
        })

        binding.addTaskButton.setOnClickListener {
            model.addNewTodoItem("New Task")
        }
    }
}