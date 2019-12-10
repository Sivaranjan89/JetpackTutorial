package com.droid.jetpacktutorial.notifications.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.notifications.util.NotificationHelper
import kotlinx.android.synthetic.main.notification_activity.*


class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_activity)

        notification_show.setOnClickListener {
            NotificationHelper(this).createNotification()
        }
    }
}