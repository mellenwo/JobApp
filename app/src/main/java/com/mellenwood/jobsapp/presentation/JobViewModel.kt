package com.mellenwood.jobsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mellenwood.jobsapp.domain.JobRepository
import kotlinx.coroutines.launch

class JobViewModel(private val repository: JobRepository): ViewModel() {
    fun getJobs(){
        viewModelScope.launch {
            val networkResponse = repository.getJobs()
            val jobs = networkResponse
        }
    }
}