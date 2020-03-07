package com.mellenwood.jobsapp.domain

data class Job(val id: String, val type: String, val location: String, val title: String,
               val description: String, val company: String)