package com.learncbse.maths12.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.learncbse.maths12.R
import com.learncbse.maths12.NotificationAdapter
import com.learncbse.maths12.data.models.VideoModel
import com.learncbse.maths12.fireBaseSettings.Config
import com.learncbse.maths12.fireBaseSettings.NotificationDB
import com.learncbse.maths12.ui.ShowNotification
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    var realm: Realm? = null
    lateinit var adapter: NotificationAdapter
    private lateinit var mInterstitialAd: InterstitialAd
    lateinit var notifications: ArrayList<Config>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        notifications = ArrayList()
        noNotificationImage.visibility = View.VISIBLE
        noNotification.visibility = View.VISIBLE

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-9391715869846599/3295713888"

        mInterstitialAd.loadAd(AdRequest.Builder().build())

        supportActionBar!!.title = "Notification"
        Realm.init(applicationContext)
        val config1 = RealmConfiguration.Builder().name("notification2.realm").build()
        realm = Realm.getInstance(config1)

        var layouManager = LinearLayoutManager(this)


        notifications = retrieveData()
        if (notifications.size > 0) {
            noNotificationImage.visibility = View.INVISIBLE
            noNotification.visibility = View.INVISIBLE
            ConfigRecycler.visibility = View.VISIBLE

        }
        ConfigRecycler.layoutManager = layouManager
        adapter = NotificationAdapter(notifications, applicationContext)
        ConfigRecycler.adapter = adapter

        adapter.onDeleteClick = { config,i ->
            realm!!.beginTransaction()
            val not = realm!!.where(NotificationDB::class.java).equalTo("content", config.content).findFirstAsync()
            (if (not != null) not else throw NullPointerException("Expression 'not' must not be null")).deleteFromRealm()
            realm!!.commitTransaction()
            adapter.notifyItemRemoved(i)
            startActivity(Intent(this,NotificationActivity::class.java))
            finish()
        }
        adapter.onItemClick = {
                config ->

                var title = config.title
                var  detail = config.content

                val intent = Intent(applicationContext, ShowNotification::class.java)
                intent.putExtra("clickedNotificationName",title)
                intent.putExtra("clickedNotificationDetails",detail)
                startActivity(intent)
            }
        }

    fun retrieveData(): ArrayList<Config> {
        notifications = ArrayList()
        val allData = realm!!.where(NotificationDB::class.java).findAll()
        allData.forEach {
            var mEv: NotificationDB = it
            var cc = Config()
            cc.title = mEv.title
            cc.imageUrl = mEv.imageUrl
            cc.content = mEv.content


            notifications.add(0, cc)
        }
        return notifications
    }

}