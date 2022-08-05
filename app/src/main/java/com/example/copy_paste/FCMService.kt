package com.example.copy_paste

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FCMService : FirebaseMessagingService() {
    private val tag: String = "FCM-thing"
    override fun onNewToken(token: String) {
        Log.d(tag, "FCM token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if(remoteMessage.data.isNotEmpty()){
            Log.d(tag, "Message data payload: ${remoteMessage.data}")
        }
        remoteMessage.notification?.let {
            Log.d(tag, "Message Notification Body: ${it.body}")
            val notif = CopyPasteNotif(applicationContext, it.title.toString(), it.body.toString())
            notif.fireNotification()
        }
    }
}