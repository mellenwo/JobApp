package com.mellenwood.jobsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mellenwood.jobsapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: JobViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getJobs()
    }
}
