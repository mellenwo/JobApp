package com.mellenwood.jobsapp.presentation.rv

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mellenwood.jobsapp.R
import com.mellenwood.jobsapp.domain.Job
import com.mellenwood.jobsapp.presentation.JobDetailActivity
import kotlinx.android.synthetic.main.job_view_item.view.*

class JobAdapter(private var dataSet: List<Job>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Job
            val intent = Intent(v.context, JobDetailActivity::class.java).apply {
                putExtra(JobDetailActivity.ARG_JOB_NAME, item.title)
                putExtra(JobDetailActivity.ARG_JOB_DESCRIPTION, item.description)
            }
            v.context.startActivity(intent)
        }
    }

    inner class JobViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val jobTitle: TextView = view.job_id_text_view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.job_view_item, parent, false)

        return JobViewHolder(textView)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val item = dataSet[position]
        holder.jobTitle.text = item.title

        with(holder.itemView) {
            tag = item
            setOnClickListener(onClickListener)
        }
    }

    fun replaceData(newItems: List<Job>){
        dataSet = newItems
        notifyDataSetChanged()
    }

}