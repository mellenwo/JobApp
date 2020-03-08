package com.mellenwood.jobsapp.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mellenwood.jobsapp.R
import com.mellenwood.jobsapp.domain.Job
import kotlinx.android.synthetic.main.job_view_item.view.*

class JobAdapter(private var dataSet: List<Job>) : RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

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
        holder.jobTitle.text = dataSet[position].title
    }

    fun replaceData(newItems: List<Job>){
        dataSet = newItems
        notifyDataSetChanged()
    }

}