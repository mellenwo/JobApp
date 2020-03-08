package com.mellenwood.jobsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mellenwood.jobsapp.R
import com.mellenwood.jobsapp.data.JobApiServiceImpl
import com.mellenwood.jobsapp.data.JobRepositoryImpl

class MainActivity : AppCompatActivity() {
    private val viewModel: JobViewModel = JobViewModel(JobRepositoryImpl(JobApiServiceImpl()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getJobs()
    }
}
