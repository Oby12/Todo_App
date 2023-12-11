package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.databinding.ActivityTaskDetailBinding
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel
    private lateinit var binding : ActivityTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory)[DetailTaskViewModel::class.java]

        //TODO 11 : Show detail task and implement delete action

        val myTask =  intent.getIntExtra(TASK_ID,0)
        detailTaskViewModel.setTaskId(myTask)

        detailTaskViewModel.task.observe(this){content ->
            if (content!=null){
                binding.apply {
                    detailEdTitle.setText(content.title)
                    detailEdDescription.setText(content.description)
                    detailEdDueDate.setText(DateConverter.convertMillisToString(content.dueDateMillis))
                }
            }

            binding.btnDeleteTask.setOnClickListener{
                detailTaskViewModel.deleteTask()
                Toast.makeText(this, "Delete Succes", Toast.LENGTH_SHORT).show()
                finish()
            }
        }


    }
}