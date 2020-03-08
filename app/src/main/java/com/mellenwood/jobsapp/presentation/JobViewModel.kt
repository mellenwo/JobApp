package com.mellenwood.jobsapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mellenwood.jobsapp.domain.Job
import com.mellenwood.jobsapp.domain.JobRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JobViewModel(private val repository: JobRepository): ViewModel() {

    var jobs = MutableLiveData<List<Job>>()

    fun getJobs() {
        viewModelScope.launch {
            val networkResponse = withContext(Dispatchers.IO) {
                repository.getJobs()
            }

            jobs.value = networkResponse
        }
    }
}