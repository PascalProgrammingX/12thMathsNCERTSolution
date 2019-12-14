package com.learncbse.maths12

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.multidex.MultiDexApplication
import com.google.android.gms.ads.MobileAds
import com.crashlytics.android.Crashlytics
import com.google.android.gms.ads.InterstitialAd
import io.fabric.sdk.android.Fabric



/**
 * Created by Shashi on 2/15/2018.
 */
class AppContext : MultiDexApplication() {

    private lateinit var mInterstitialAd: InterstitialAd


    companion object
    {
        val channelNewVideoID : String = "channelNewVideo"
        val channelNewsID : String = "channelNews"
    }

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this, resources.getString(R.string.ad_mob_id))
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = resources.getString(R.string.interstitial_id)
        Fabric.with(this, Crashlytics())
        createNotificationsChannel()
    }

    private fun createNotificationsChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel1 = NotificationChannel(channelNewVideoID,
                    "New Video Added",
                    NotificationManager.IMPORTANCE_HIGH)
            channel1.description = "Notification Channel for new video"

            var channel2 = NotificationChannel(channelNewsID,
                    "News",
                    NotificationManager.IMPORTANCE_LOW)
            channel2.description = "Notification Channel for news"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
        }
    }

}