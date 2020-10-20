package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(val item: ToDo?) : Fragment() {
    private lateinit var id: TextView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var status: TextView
    private lateinit var category: TextView
    private lateinit var duration: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_detail, container, false)
        id = rootview.findViewById(R.id.id)
        title = rootview.findViewById(R.id.title)
        description = rootview.findViewById(R.id.description)
        status = rootview.findViewById(R.id.status)
        category = rootview.findViewById(R.id.category)
        duration = rootview.findViewById(R.id.duration)
        id.text = item?.id.toString()
        title.text = item?.title
        description.text=item?.description
        status.text=item?.status
        category.text=item?.category
        duration.text=item?.duration
        return rootview
    }

}
