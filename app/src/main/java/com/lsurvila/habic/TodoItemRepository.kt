package com.lsurvila.habic

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TodoItemRepository(private val todoItemDao: TodoItemDao) {

    val allTodoItems: Flow<List<TodoItemEntity>> = todoItemDao.getTodoItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(todoItem: TodoItemEntity) {
        todoItemDao.insert(todoItem)
    }
}