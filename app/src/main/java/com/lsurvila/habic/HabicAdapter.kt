package com.lsurvila.habic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class HabicAdapter : ListAdapter<TodoItemEntity, HabicAdapter.ViewHolder>(TODO_ITEMS_COMPARATOR) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_habic, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTextView.text = getItem(position).todoItem
    }

    companion object {
        private val TODO_ITEMS_COMPARATOR = object : DiffUtil.ItemCallback<TodoItemEntity>() {
            override fun areItemsTheSame(oldItem: TodoItemEntity, newItem: TodoItemEntity): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: TodoItemEntity, newItem: TodoItemEntity): Boolean {
                return oldItem.todoItem == newItem.todoItem
            }
        }
    }
}