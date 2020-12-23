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
        binding.habicListView.layoutManager = LinearLayoutManager(this)
        val adapter = HabicAdapter()
        binding.habicListView.adapter = adapter

        val database by lazy { HabicDatabase.getDatabase(this) }
        val repository by lazy { TodoItemRepository(database.todoItemDao()) }
        val model: HabicViewModel by viewModels {
            HabicViewModelFactory(repository)
        }

        model.allTodoItems.observe(this, { todoItems ->
            adapter.submitList(todoItems)
        })

        binding.addTaskButton.setOnClickListener {
            model.insert(TodoItemEntity(0, "New Task"))
        }
    }
}