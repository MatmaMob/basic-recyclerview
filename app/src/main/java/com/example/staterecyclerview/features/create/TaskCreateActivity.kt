package com.example.staterecyclerview.features.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.staterecyclerview.R
import com.example.staterecyclerview.data.Item
import kotlinx.android.synthetic.main.activity_task_create.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TaskCreateActivity : AppCompatActivity() {

    private val taskCreateViewModel: TaskCreateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_create)

        createBtn.setOnClickListener {
            taskCreateViewModel.createTask(
                Item(
                    titleInputLayout.editText?.text.toString(),
                    "",
                    ""
                )
            ) {
                finish()
            }
        }
    }
}
