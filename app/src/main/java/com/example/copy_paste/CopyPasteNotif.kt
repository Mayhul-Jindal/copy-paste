package com.example.copy_paste

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.*
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat


class CopyPasteNotif(var context: Context, var title: String, var msg: String) {
    val channelId: String = "FCM100"
    val channelName: String = "FCMMessage"
    val notificationManager = context.applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    lateinit var notificationChannel: NotificationChannel;
    lateinit var notificationBuilder: NotificationCompat.Builder
    var brCopy: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(title, msg)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Copied!", Toast.LENGTH_SHORT).show()
        }
    }
    fun fireNotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        // testing for clipboard shit
        val intentFilter = IntentFilter("com.example.ACTION_COPY")
        context.registerReceiver(brCopy, intentFilter)

        val copy = Intent("com.example.ACTION_COPY")
        val pendingIntent = PendingIntent.getBroadcast(context, 0, copy, PendingIntent.FLAG_IMMUTABLE)

//        // simple intent which open home_screen
//        val intent = Intent(context, MainActivity::class.java)
//        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)

//        // testing for deep links
//        val testIntent = Intent(Intent.ACTION_VIEW,"https://example.com/copied_text=${"buri buri zaemon"}".toUri(), context, MainActivity::class.java)
//        val pending: PendingIntent = TaskStackBuilder.create(context).run {
//            addNextIntentWithParentStack(testIntent)
//            getPendingIntent(0, PendingIntent.FLAG_IMMUTABLE)
//        }
        notificationBuilder = NotificationCompat.Builder(context, channelId)
        notificationBuilder.setSmallIcon(R.drawable.ic_launcher_background)
        notificationBuilder.addAction(R.drawable.ic_launcher_background, "Copy", pendingIntent)
        notificationBuilder.setContentTitle(title)
        notificationBuilder.setContentText(msg)
        notificationBuilder.setAutoCancel(true)
        notificationManager.notify(100, notificationBuilder.build())
    }
}