package com.learncbse.maths12.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.learncbse.maths12.R
import kotlinx.android.synthetic.main.activity_show_notification.*

class ShowNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_notification)
        setSupportActionBar(findViewById(R.id.my_toolbarShow))
        supportActionBar!!.title = "Notification"

        val data = intent.extras
        val t = data.getString("clickedNotificationName")
        val D = data.getString("clickedNotificationDetails")

        notificationTitle.text = t
        notificationDetails.text = D
    }
}
//ok
//open postman first