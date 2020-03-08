package com.mellenwood.jobsapp.data

import com.mellenwood.jobsapp.domain.Job
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobApiServiceImpl: JobApiService {

    override suspend fun getJobs(): List<Job> {
        val service: JobApiService = createRetrofitService()
        return service.getJobs()
    }

    private fun createRetrofitService(): JobApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobs.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(JobApiService::class.java)
    }

}