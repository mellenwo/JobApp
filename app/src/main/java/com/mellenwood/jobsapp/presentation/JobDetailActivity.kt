package com.mellenwood.jobsapp.presentation

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.mellenwood.jobsapp.R
import kotlinx.android.synthetic.main.job_detail.*

class JobDetailActivity : AppCompatActivity() {

    private var jobTitle: String? = null
    private var jobDescription: String? = null

    companion object {
        const val ARG_JOB_NAME = "job_name"
        const val ARG_JOB_DESCRIPTION = "job_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.job_detail)

        val intent = intent
        jobTitle = intent.getStringExtra(ARG_JOB_NAME)
        jobDescription = intent.getStringExtra(ARG_JOB_DESCRIPTION)

        job_title_text_view.text = jobTitle
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            job_description_text_view.text = Html.fromHtml(jobDescription, Html.FROM_HTML_MODE_COMPACT)
        } else {
            job_description_text_view.text = Html.fromHtml(jobDescription)
        }
    }

}