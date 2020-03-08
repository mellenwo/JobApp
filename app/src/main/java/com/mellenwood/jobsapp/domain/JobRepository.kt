package com.mellenwood.jobsapp.domain

interface JobRepository {
    suspend fun getJobs(): List<Job>
}