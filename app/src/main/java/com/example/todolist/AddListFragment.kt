package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class AddListFragment : Fragment() {
    private lateinit var id: EditText
    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var status: EditText
    private lateinit var category: EditText
    private lateinit var duration: EditText
    private lateinit var btn: Button
    private lateinit var item: ToDo
    private var listener: AddItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_add_list, container, false)
        item = ToDo(1, "", "", "", "", "")
        id = rootview.findViewById(R.id.id)
        title = rootview.findViewById(R.id.title)
        description = rootview.findViewById(R.id.description)
        status = rootview.findViewById(R.id.status)
        category = rootview.findViewById(R.id.category)
        duration = rootview.findViewById(R.id.duration)
        btn=rootview.findViewById(R.id.add)




        listener = object : AddItemClickListener {
            override fun itemClick(item: ToDo) {
                (activity as MainActivity?)?.itemClick(item)
            }
        }
        btn.setOnClickListener({

            item.id = id.text.toString().toInt()
            item.category = category.text.toString()
            item.title = title.text.toString()
            item.description = description.text.toString()
            item.status = status.text.toString()
            item.duration = duration.text.toString()
            listener?.itemClick(item)
        })

        return rootview
    }

    internal interface AddItemClickListener {
        fun itemClick(item: ToDo)
    }
}
