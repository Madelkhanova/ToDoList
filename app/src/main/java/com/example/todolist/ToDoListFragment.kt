package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 */
class ToDoListFragment(val toDoList: ArrayList<ToDo>) : Fragment() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var viewAdapter: ToDoListAdapter
    private lateinit var viewManager: LinearLayoutManager
    private var listener: ToDoListAdapter.ItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false)


        myRecyclerView = rootView.findViewById(R.id.myRecyclerView)
        viewManager = LinearLayoutManager(context)

        myRecyclerView.layoutManager = viewManager
        val dividerItemDecoration = DividerItemDecoration(
            myRecyclerView.context,
            viewManager.orientation
        )

        myRecyclerView.addItemDecoration(dividerItemDecoration)
        listener = object : ToDoListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: ToDo?) {
                val fragment = DetailFragment(item)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_container, fragment)
                    ?.addToBackStack("tag")
                    ?.commit()
            }
        }
        viewAdapter = context?.let {
            ToDoListAdapter(
                toDoList, it,
                listener as ToDoListAdapter.ItemClickListener
            )
        }!!
        myRecyclerView.adapter = viewAdapter

        return rootView

    }
}
