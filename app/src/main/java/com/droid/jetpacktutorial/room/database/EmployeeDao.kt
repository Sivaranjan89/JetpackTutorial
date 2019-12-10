package com.droid.jetpacktutorial.room.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEmployee(employee: Employee)

    @Query("SELECT * FROM employee")
    fun getAllEmployees() : LiveData<List<Employee>>

    @Query("SELECT * FROM employee WHERE name=:name")
    fun getEmployee(name: String) : Employee

    @Query("DELETE from employee")
    fun deleteAllEmployees() : Int

    @Delete
    fun deleteEmployee(employee: Employee) : Int
}