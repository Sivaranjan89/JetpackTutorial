package com.droid.jetpacktutorial.room.usecase

import com.droid.jetpacktutorial.room.database.Employee
import com.droid.jetpacktutorial.room.repository.RoomRepository

class RoomUseCase(roomRepository: RoomRepository) {

    private var repository = roomRepository

    fun addEmployee(employee: Employee) = repository.addEmployee(employee)

    fun getAllEmployees() = repository.getAllEmployees()
}