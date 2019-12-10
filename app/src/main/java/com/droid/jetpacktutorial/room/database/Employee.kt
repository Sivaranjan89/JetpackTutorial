package com.droid.jetpacktutorial.room.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * If we dont specify tableName it will take class name as table Name
 * entity will declare this class as a table
 * columnInfo will declare that field as a column in this table
 */
@Entity(tableName = "Employee")
data class Employee (

    @PrimaryKey
    @ColumnInfo
    var name: String,

    @ColumnInfo
    var age: String,

    @ColumnInfo
    var mobile: String

)