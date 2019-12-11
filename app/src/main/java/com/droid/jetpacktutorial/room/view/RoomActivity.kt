package com.droid.jetpacktutorial.room.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.dagger.DaggerApplicationComponent
import com.droid.jetpacktutorial.room.adapter.RoomAdapter
import com.droid.jetpacktutorial.room.viewmodel.RoomViewModel
import javax.inject.Inject

/**
 * Add the below Dependencies in app build.gradle
 * implementation "androidx.room:room-runtime:$roomVersion"
 * kapt "androidx.room:room-compiler:$roomVersion"
 * implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
 */
class RoomActivity : AppCompatActivity() {

    private lateinit var listView: RecyclerView

    @Inject
    lateinit var roomViewModel: RoomViewModel

    @Inject
    lateinit var roomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_activity)

        initDagger()

        init()

        roomViewModel.addEmployees()

        roomViewModel.getAllEmployees()?.observe(this, Observer {
            roomAdapter.updateList(it)

        })
    }

    private fun init() {
        listView = findViewById(R.id.emp_list)
        listView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        listView.adapter = roomAdapter
    }

    private fun initDagger() {
        DaggerApplicationComponent.builder().application(application).build().inject(this)
    }
}