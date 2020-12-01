package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todoapp.network.ApiClient
import com.example.todoapp.network.ApiService
import kotlinx.android.synthetic.main.fragment_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailFragment : Fragment() {
    private lateinit var id: TextView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var status: TextView
    private lateinit var category: TextView
    private lateinit var duration: TextView
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_detail, container, false)
        return rootview
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = view.findViewById(R.id.id)
        title = view.findViewById(R.id.title)
        description = view.findViewById(R.id.description)
        status = view.findViewById(R.id.status)
        category = view.findViewById(R.id.category)
        duration = view.findViewById(R.id.duration)
        val idToDo = args.todoId
        val item = getById(idToDo)
        id.text = item.id.toString()
        title.text = item.title
        description.text = item.userId.toString()
        status.text = item.completed.toString()
        back.setOnClickListener()
        {
            val action = DetailFragmentDirections.actionDetailToTodo()

            view.findNavController().navigate(action)
        }
    }

    fun getById(id: Int): ToDo {
        val apiService: ApiService? = ApiClient.client?.create(ApiService::class.java)
        val call: Call<ToDo>? = apiService?.getTodoById(id)
        var item = ToDo(1, 1, "", false)

        call?.enqueue(object : Callback<ToDo> {
            override fun onResponse(
                call: Call<ToDo>?,
                response: Response<ToDo>
            ) {
                item = response.body() as ToDo

            }

            override fun onFailure(call: Call<ToDo>?, t: Throwable) {
                Toast.makeText(context, "error", Toast.LENGTH_LONG).show()
            }
        })
        return item
    }
}
