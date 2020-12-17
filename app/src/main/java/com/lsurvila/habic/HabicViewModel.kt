package com.lsurvila.habic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabicViewModel : ViewModel() {

    private val todoItems = arrayListOf("Gym", "Emails", "Work", "Study")
    private val todoItemsLiveData = MutableLiveData<List<String>>()

    fun getTodoItems(): LiveData<List<String>> {
        todoItemsLiveData.postValue(todoItems)
        return todoItemsLiveData
    }

    fun addNewTodoItem(newTodoItem: String) {
        todoItems.add(newTodoItem)
        todoItemsLiveData.postValue(todoItems)
    }
}