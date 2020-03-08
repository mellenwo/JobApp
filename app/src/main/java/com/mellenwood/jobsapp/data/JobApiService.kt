package com.mellenwood.jobsapp.data

import com.mellenwood.jobsapp.domain.Job
import retrofit2.http.GET

interface JobApiService {
    @GET("/positions.json?description=python&location=new+york")
    suspend fun getJobs(): List<Job>
}