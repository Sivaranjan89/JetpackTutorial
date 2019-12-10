package com.droid.jetpacktutorial.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.dagger.DaggerApplicationComponent
import com.droid.jetpacktutorial.home.adapter.TopicsAdapter
import com.droid.jetpacktutorial.home.viewmodel.HomeViewModel
import com.droid.jetpacktutorial.security.view.SecurityActivity
import com.droid.jetpacktutorial.navigation.view.NavigationActivity
import com.droid.jetpacktutorial.notifications.view.NotificationActivity
import com.droid.jetpacktutorial.palette.view.PaletteActivity
import com.droid.jetpacktutorial.preferences.view.PreferenceActivity
import com.droid.jetpacktutorial.room.view.RoomActivity
import com.droid.jetpacktutorial.utils.openActivity
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var topicsAdapter: TopicsAdapter

    lateinit var listView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDagger()

        init()

        homeViewModel.getSelectedTopic().observe(this, Observer {topic ->
            navigateToTopic(topic)
        })
    }

    private fun navigateToTopic(topic: String?) {
        if (topic.equals("Security")) {
            openActivity(SecurityActivity::class.java)
        }
        else if (topic.equals("Navigation")) {
            openActivity(NavigationActivity::class.java)
        }
        else if (topic.equals("Room")) {
            openActivity(RoomActivity::class.java)
        } else if (topic.equals("Palette")) {
            openActivity(PaletteActivity::class.java)
        } else if (topic.equals("Notifications")) {
            openActivity(NotificationActivity::class.java)
        } else if (topic.equals("Preferences")) {
            openActivity(PreferenceActivity::class.java)
        }
    }

    private fun init() {
        listView = findViewById(R.id.list)
        listView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        listView.adapter = topicsAdapter
        topicsAdapter.setViewModel(homeViewModel)
        topicsAdapter.updateList(homeViewModel.topics)
    }

    private fun initDagger() {
        DaggerApplicationComponent.builder().application(application).build().inject(this)
    }
}
