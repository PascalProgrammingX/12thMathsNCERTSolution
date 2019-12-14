package com.learncbse.maths12

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.learncbse.maths12.fireBaseSettings.NotificationDB
import com.learncbse.maths12.ui.NotificationActivity
import io.realm.Realm
import io.realm.RealmConfiguration

class MyService  : FirebaseMessagingService() {
    var realm: Realm? = null
    override fun onMessageReceived(p0: RemoteMessage?) {
        Realm.init(applicationContext)
        val config1 = RealmConfiguration.Builder().name("notification2.realm").build()
        realm = Realm.getInstance(config1)
        val data = p0!!.data
        val title : String? = data.get("title")
        val content : String? = data.get("content")
        val imageUrl : String? = data.get("imageUrl")

        realm!!.beginTransaction()
        var conf = realm!!.createObject(NotificationDB::class.java)
        conf.title = title
        conf.content = content
        conf.imageUrl = imageUrl

        realm!!.commitTransaction()
        sendNotification(p0)
    }
    private fun sendNotification(remoteMessage: RemoteMessage?) {
        val largeIcon : Bitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.app_icon)
        var intentNotification : Intent = Intent(this, NotificationActivity::class.java)
        var pendingIntent : PendingIntent = PendingIntent.getActivity(this,0,intentNotification,0)
        var notificationManager : NotificationManagerCompat = NotificationManagerCompat.from(this)
        var notification = NotificationCompat.Builder(this,AppContext.channelNewVideoID)
                .setSmallIcon(R.drawable.ic_study_2)
                .setLargeIcon(largeIcon)
                .setContentText(remoteMessage!!.data.get("content"))
                .setContentTitle(remoteMessage.data.get("title"))
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
        notificationManager.notify(11,notification)
    }
}
