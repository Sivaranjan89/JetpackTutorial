package com.droid.jetpacktutorial.room.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.droid.jetpacktutorial.room.database.Employee
import com.droid.jetpacktutorial.room.database.EmployeeDao
import com.droid.jetpacktutorial.room.database.EmployeeDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomRepository(context: Context) {

    private var dao: EmployeeDao?

    init {
        dao = EmployeeDatabase.getInstance(context)?.employeeDao()
    }

    fun addEmployee(employee: Employee) {
        GlobalScope.launch {
            dao?.addEmployee(employee)
        }
    }

    fun getAllEmployees() = dao?.getAllEmployees()
}