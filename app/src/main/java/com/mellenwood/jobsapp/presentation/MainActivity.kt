package com.mellenwood.jobsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mellenwood.jobsapp.R
import com.mellenwood.jobsapp.domain.Job
import com.mellenwood.jobsapp.presentation.rv.JobAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: JobViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val adapter = JobAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getJobs()

        viewModel.jobs.observe(this,
            Observer<List<Job>> { it?.let {
                adapter.replaceData(it)
            } }
        )

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = adapter

        recyclerView = findViewById<RecyclerView>(R.id.job_rv).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
