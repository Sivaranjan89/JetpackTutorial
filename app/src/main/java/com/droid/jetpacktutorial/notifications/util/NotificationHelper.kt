package com.droid.jetpacktutorial.notifications.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.droid.jetpacktutorial.R
import com.droid.jetpacktutorial.home.view.HomeActivity

class NotificationHelper(val context: Context) {

    private val NOTIFICATION_CHANNEL = "Jetpack"
    private val NOTIFICATION_ID = 1001

    fun createNotification() {
        createChannel()

        val intent = Intent(context, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val icon = BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher_round)

        val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setLargeIcon(icon)
            .setContentTitle("Jetpack Components")
            .setContentText("This project contains sample codes for Jetpack components")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = NOTIFICATION_CHANNEL
            val channelDescription = "This project contains sample codes for Jetpack components"
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(name, name, importance).apply {
                description = channelDescription
            }

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }
    }
}