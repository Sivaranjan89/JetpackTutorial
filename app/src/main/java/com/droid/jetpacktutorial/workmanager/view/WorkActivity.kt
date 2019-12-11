package com.droid.jetpacktutorial.workmanager.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.R.*
import com.droid.jetpacktutorial.workmanager.workers.ActivityWorker
import com.droid.jetpacktutorial.workmanager.workers.Worker
import kotlinx.android.synthetic.main.work_activity.*
import java.util.concurrent.TimeUnit


class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.work_activity)

        one_time.setOnClickListener {
            val oneTimeRequest = OneTimeWorkRequestBuilder<Worker>()
                .build()

            WorkManager.getInstance().enqueue(oneTimeRequest)
        }

        wifi_connected.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

            val oneTimeRequest = OneTimeWorkRequestBuilder<Worker>()
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance().enqueue(oneTimeRequest)
        }

        chain.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

            val notification = OneTimeWorkRequestBuilder<Worker>()
                .setConstraints(constraints)
                .build()

            val activity = OneTimeWorkRequestBuilder<ActivityWorker>()
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance().beginWith(notification)
                .then(activity)
                .enqueue()
        }

        periodic.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build()

            val periodicWorkRequest =
                PeriodicWorkRequest.Builder(Worker::class.java, 10, TimeUnit.MINUTES)
                    .setConstraints(constraints)
                    .build()

            WorkManager.getInstance().enqueue(periodicWorkRequest)
        }

    }
}