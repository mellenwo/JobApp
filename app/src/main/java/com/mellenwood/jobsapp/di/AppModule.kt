package com.mellenwood.jobsapp.di

import com.mellenwood.jobsapp.data.JobApiService
import com.mellenwood.jobsapp.data.JobApiServiceImpl
import com.mellenwood.jobsapp.data.JobRepositoryImpl
import com.mellenwood.jobsapp.domain.JobRepository
import com.mellenwood.jobsapp.presentation.JobViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class AppModule {
    companion object {
        val appModule = module {

            single<JobRepository> { JobRepositoryImpl(get()) }
            single<JobApiService> { JobApiServiceImpl() }

            viewModel { JobViewModel(get()) }
        }
    }
}