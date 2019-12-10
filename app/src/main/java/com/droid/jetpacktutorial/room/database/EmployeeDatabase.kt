package com.droid.jetpacktutorial.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Employee::class), version = 1, exportSchema = false)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao


    companion object {
        @Volatile private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context) : EmployeeDatabase? {
            if (INSTANCE == null) {
                synchronized(EmployeeDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, EmployeeDatabase::class.java, "employees").build()
                }
            }

            return INSTANCE
        }
    }

}