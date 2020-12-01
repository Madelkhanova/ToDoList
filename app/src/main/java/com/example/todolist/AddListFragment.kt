package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.todoapp.network.ApiClient
import com.example.todoapp.network.ApiService
import kotlinx.android.synthetic.main.fragment_add_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class AddListFragment : Fragment() {
    private lateinit var btn: Button
    private lateinit var item: ToDo
    private var listener: AddItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_add_list, container, false)
        item = ToDo(1, 1, "", false)
        btn = rootview.findViewById(R.id.add)

        listener = object : AddItemClickListener {
            override fun itemClick(item: ToDo) {
                // (activity as MainActivity?)?.itemClick(item)
                val action = AddListFragmentDirections.actionAddTodoToTodo()
                action.idToDo=item.id
                action.userId=item.userId
                action.title=item.title
                action.complete=item.completed
                rootview.findNavController().navigate(action)
            }
        }

        btn.setOnClickListener {

            item.id = iD.text.toString().toInt()
            item.title = title.text.toString()
            item.userId = user_id.text.toString().toInt()
            item.completed = completed.text.toString().toBoolean()
            listener?.itemClick(item)
        }

        return rootview
    }

    internal interface AddItemClickListener {
        fun itemClick(item: ToDo)
    }
}
