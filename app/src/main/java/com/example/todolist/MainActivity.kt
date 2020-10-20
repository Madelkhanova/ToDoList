package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    val toDoList = ArrayList<ToDo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 1..10) {
            toDoList.add(
                ToDo(
                    i,
                    "Do Homework " + i,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." + i,
                    "Status " + i,
                    "Category " + i,
                    "Duration " + i
                )
            )
        }
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_container, ToDoListFragment(toDoList))
            .commit()
    }

    fun onClick(view: View) {
        fragmentManager.beginTransaction().replace(R.id.main_container, AddListFragment())
            .commit()
    }


    fun itemClick(item: ToDo) {
        toDoList.add(item)
        fragmentManager.beginTransaction().replace(R.id.main_container, ToDoListFragment(toDoList))
            .commit()
    }
}
