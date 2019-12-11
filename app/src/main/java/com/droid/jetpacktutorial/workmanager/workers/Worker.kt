package com.droid.jetpacktutorial.workmanager.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.droid.jetpacktutorial.notifications.util.NotificationHelper

class Worker(val context: Context, val workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        NotificationHelper(context).createNotification()
        return Result.success()
    }
}