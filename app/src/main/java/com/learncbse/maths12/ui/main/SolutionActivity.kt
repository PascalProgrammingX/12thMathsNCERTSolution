package com.learncbse.maths12.ui.main

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.learncbse.maths12.R
import com.learncbse.maths12.data.DataSource
import com.learncbse.maths12.data.models.Exercice
import com.learncbse.maths12.ui.exercicesdetail.ExercicesDetailActivity
import kotlinx.android.synthetic.main.activity_solution.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.messaging.FirebaseMessaging


class SolutionActivity : AppCompatActivity(), (Exercice) -> Unit {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution)

        toolbar.title = "Solution"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back)
        toolbar.setNavigationOnClickListener{
            finish()
        }
        // Setup recyclerView
        val exercicesAdapter = ExercicesAdapter(DataSource.exercices, this)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        recyclerview_main.adapter = exercicesAdapter

        FirebaseMessaging.getInstance().subscribeToTopic("maths12")
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {

                    }
                }
    }



    override fun onStart() {
        super.onStart()
        val adRequest = AdRequest.Builder().build()
        first_ad.loadAd(adRequest)
    }


    override fun invoke(exercice: Exercice) {

        // Start exercices detail with exercice ID
        val intent = Intent(this, ExercicesDetailActivity::class.java)
        intent.putExtra("ID", exercice.exerciceId)
        intent.putExtra("NAME", exercice.exerciceName)
        startActivity(intent)
    }

}
