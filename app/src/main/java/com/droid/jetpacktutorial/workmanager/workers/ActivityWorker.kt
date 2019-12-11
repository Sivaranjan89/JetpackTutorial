package com.droid.jetpacktutorial.workmanager.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.droid.jetpacktutorial.home.view.HomeActivity
import com.droid.jetpacktutorial.utils.openFreshActivity

class ActivityWorker(val context: Context, val workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        context.openFreshActivity(HomeActivity::class.java)
        return Result.success()
    }
}