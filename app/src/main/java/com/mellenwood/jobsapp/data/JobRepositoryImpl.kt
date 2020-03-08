package com.mellenwood.jobsapp.data

import com.mellenwood.jobsapp.domain.Job
import com.mellenwood.jobsapp.domain.JobRepository

class JobRepositoryImpl(private val remoteDataSource: JobApiService): JobRepository {

    override suspend fun getJobs(): List<Job> {
        return remoteDataSource.getJobs()
    }

}