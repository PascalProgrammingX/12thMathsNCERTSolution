package com.learncbse.maths12.ui.main

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learncbse.maths12.BuildConfig
import com.learncbse.maths12.R
import com.learncbse.maths12.data.Category
import com.learncbse.maths12.data.DataSource
import com.learncbse.maths12.ui.NotificationActivity
import kotlinx.android.synthetic.main.fragment_navigation.view.*

/**
 * Created by Pedro Massango on 1/16/18.
 */
class NavigationFragment : Fragment(), CategoriesAdapter.ItemClick {
    override fun itemClickListener(item: Any) {
        val category = item as Category
        when (category.title) {

            "Contact Us" -> sendEmail()
            "Share App" -> shareApp()
            "Rate App"  -> rateApp()
            "Privacy Policy"  -> privacyPolicy()
            "More Apps"  -> moreApps()
            "Notifications"  -> notification()



            "12 Physics Solution" -> playStore("com.learncbse.physics12")
            "12 Chemistry Solution" -> playStore("com.learncbse.chemistry12")
            "H C Verma 2 Solution" -> playStore("com.learncbse.hcvermapart2")
            "JEE Main Previous Year Paper" -> playStore("com.learncbse.jeemainpyrqp")
            "JEE Advance Previous Year Paper" -> playStore("com.learncbse.jeeadvancepreviousyear")
            "NEET Previous Year Paper" -> playStore("com.learncbse.neetpreviousyear")



        }
    }

    private fun notification() {
        startActivity(Intent(context, NotificationActivity::class.java))
    }

    private fun moreApps() {
        val url = "https://play.google.com/store/apps/developer?id=Learn+CBSE"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun privacyPolicy() {
        val url = "https://learnncertsolutions.blogspot.com/p/privacy-policy-class-12-maths-ncert.html"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "info@learncbse.net", null))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "12 Maths NCERT Solution")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Please share your suggesion or feedback...")
        ContextCompat.startActivity(activity!!, Intent.createChooser(emailIntent, "Send email"), null)
    }

    private fun rateApp() {
        val uri = Uri.parse("market://details?id=" +  BuildConfig.APPLICATION_ID)
        val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(myAppLinkToMarket)
        } catch (e: ActivityNotFoundException) {
            // Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
        }

    }

    private fun shareApp() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "12th Maths NCERT Solution")
        var shareMessage = "\nLet me recommend you this application\n\n"
        shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        startActivity(Intent.createChooser(shareIntent, "Share App"))
    }

    private fun playStore(appId: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("market://details?id=$appId")
            startActivity(intent)
        } catch (e: Exception) { //google play app is not installed
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=$appId")
            startActivity(intent)
        }

    }

    companion object {
        var INSTACE: NavigationFragment? = null

        fun getInstance(): NavigationFragment {
            if (INSTACE == null) {
                INSTACE == NavigationFragment()
            }

            return INSTACE!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_navigation, container, false)

        val adapter = CategoriesAdapter(activity!!, DataSource.categories, this)

        val recyclerview = root.recyclerview_categories
        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = adapter

        return root
    }


}




