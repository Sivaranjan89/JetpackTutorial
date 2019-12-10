package com.droid.jetpacktutorial.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droid.jetpacktutorial.databinding.TopicRowBinding
import com.droid.jetpacktutorial.home.viewmodel.HomeViewModel

class TopicsAdapter(val context: Context) :
    RecyclerView.Adapter<TopicsAdapter.ViewHolder>() {

    var topics: List<String> = ArrayList()
    lateinit var model: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = TopicRowBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topics.get(position), model)
    }

    class ViewHolder(
        val binding: TopicRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String, viewModel: HomeViewModel) {
            binding.topicName = data
            binding.model = viewModel
        }
    }

    fun updateList(newtopics: List<String>) {
        topics = newtopics
        notifyDataSetChanged()
    }

    fun setViewModel(viewModel: HomeViewModel) {
        model = viewModel
    }
}