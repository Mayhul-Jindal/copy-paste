package com.example.copy_paste

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.net.toUri

class CopyPasteNotif(var context: Context, var title: String, var msg: String) {
    val channelId: String = "FCM100"
    val channelName: String = "FCMMessage"
    val notificationManager = context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationChannel: NotificationChannel;
    lateinit var notificationBuilder: NotificationCompat.Builder

    fun fireNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

//        val intent = Intent(context, MainActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // testing
        val testIntent = Intent(Intent.ACTION_VIEW,"https://example.com/copied_text=${"buri buri zaemon"}".toUri(), context, MainActivity::class.java)
        val pending: PendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(testIntent)
            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
        }
        notificationBuilder = NotificationCompat.Builder(context, channelId)
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
        notificationBuilder.addAction(R.drawable.ic_launcher_background, "Copy", pending)
        notificationBuilder.setContentTitle(title)
        notificationBuilder.setContentText(msg)
        notificationBuilder.setAutoCancel(true)
        notificationManager.notify(100, notificationBuilder.build())
    }
}