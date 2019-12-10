package com.droid.jetpacktutorial.room.viewmodel

import androidx.lifecycle.ViewModel
import com.droid.jetpacktutorial.room.database.Employee
import com.droid.jetpacktutorial.room.usecase.RoomUseCase

class RoomViewModel(roomUseCase: RoomUseCase) : ViewModel() {

    private var useCase = roomUseCase

    fun addEmployees() {
        val employee1 = Employee(name = "Sivaranjan", age = "30", mobile = "9963986673")
        val employee2 = Employee(name = "Mirunalini", age = "29", mobile = "9963986777")
        val employee3 = Employee(name = "Dheesha", age = "20", mobile = "9963986333")

        val list = arrayListOf(employee1, employee2, employee3)

        for (i in list) {
            useCase.addEmployee(i)
        }
    }

    fun getAllEmployees() = useCase.getAllEmployees()

}