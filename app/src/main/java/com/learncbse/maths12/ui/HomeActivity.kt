package com.learncbse.maths12.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.learncbse.maths12.R
import com.learncbse.maths12.data.OthersDataSource
import com.learncbse.maths12.ui.main.*
import kotlinx.android.synthetic.main.home_cards.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val date = Date()
        val cal: Calendar = Calendar.getInstance()
        val hour: Int = cal.get(Calendar.HOUR_OF_DAY)
        cal.time = date
        var greet = ""
        if (hour <= 11){
            greet = "GOOD MORNING"
        }else if (hour >11 && hour <16){
            greet = "GOOD  AFTERNOON"
        }else if (hour >= 16 && hour < 21){
            greet = "GOOD EVENING"
        }else if (hour >= 21){
            greet = "GOOD NIGHT"
        }

        greeting.text = greet


        card_1.setOnClickListener{
            startActivity(Intent(this, TextBookActivity::class.java))
        }

        card_2.setOnClickListener{
            startActivity(Intent(this, SolutionActivity::class.java))
        }

        card_3.setOnClickListener{
         startActivity(Intent(this, NotesActivity::class.java))
        }

        card_4.setOnClickListener{
            startActivity(Intent(this, FormulaActivity::class.java))
        }

        card_5.setOnClickListener{
            startActivity(Intent(this, PracticePaperActivity::class.java))
        }

        card_6.setOnClickListener{
            startActivity(Intent(this, PreviousPaperActivity::class.java))
        }


    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
