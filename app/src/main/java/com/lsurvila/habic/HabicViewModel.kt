package com.lsurvila.habic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HabicViewModel : ViewModel() {

    private val todoItemsLiveData = MutableLiveData<List<String>>()

    fun getTodoItems(): LiveData<List<String>> {
        todoItemsLiveData.postValue(listOf("Gym", "Emails", "Work", "Study"))
        return todoItemsLiveData
    }
}