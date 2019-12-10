package com.droid.jetpacktutorial.room.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droid.jetpacktutorial.databinding.EmpRowBinding
import com.droid.jetpacktutorial.databinding.TopicRowBinding
import com.droid.jetpacktutorial.home.viewmodel.HomeViewModel
import com.droid.jetpacktutorial.room.database.Employee
import com.droid.jetpacktutorial.room.viewmodel.RoomViewModel

class RoomAdapter(val context: Context) :
    RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    var employees: List<Employee> = ArrayList()
    lateinit var model: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = EmpRowBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(employees.get(position))
    }

    class ViewHolder(
        val binding: EmpRowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Employee) {
            binding.employee = data
        }
    }

    fun updateList(emp: List<Employee>) {
        employees = emp
        notifyDataSetChanged()
    }
}