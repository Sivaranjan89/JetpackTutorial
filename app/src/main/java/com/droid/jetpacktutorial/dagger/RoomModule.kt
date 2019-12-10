package com.droid.jetpacktutorial.dagger

import android.app.Application
import com.droid.jetpacktutorial.room.adapter.RoomAdapter
import com.droid.jetpacktutorial.room.repository.RoomRepository
import com.droid.jetpacktutorial.room.usecase.RoomUseCase
import com.droid.jetpacktutorial.room.viewmodel.RoomViewModel
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun bindModel(roomUseCase: RoomUseCase) : RoomViewModel = RoomViewModel(roomUseCase)

    @Provides
    fun bindUseCase(roomRepository: RoomRepository) : RoomUseCase = RoomUseCase(roomRepository)

    @Provides
    fun bindRepo(application: Application) : RoomRepository = RoomRepository(application)

    @Provides
    fun bindAdapter(application: Application) : RoomAdapter = RoomAdapter(application)

}