package com.droid.jetpacktutorial.dagger

import android.app.Application
import com.droid.jetpacktutorial.home.view.HomeActivity
import com.droid.jetpacktutorial.room.view.RoomActivity
import com.droid.jetpacktutorial.workmanager.view.WorkActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [HomeModule::class, RoomModule::class])
interface ApplicationComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(roomActivity: RoomActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}