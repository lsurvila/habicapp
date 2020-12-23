package com.lsurvila.habic

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class HabicViewModel(private val repository: TodoItemRepository) : ViewModel() {

    val allTodoItems: LiveData<List<TodoItemEntity>> = repository.allTodoItems.asLiveData()

    fun insert(todoItem: TodoItemEntity) = viewModelScope.launch {
        repository.insert(todoItem)
    }
}

class HabicViewModelFactory(private val repository: TodoItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HabicViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HabicViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
