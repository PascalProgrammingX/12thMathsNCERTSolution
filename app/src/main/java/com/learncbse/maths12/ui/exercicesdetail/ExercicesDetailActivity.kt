package com.learncbse.maths12.ui.exercicesdetail


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.learncbse.maths12.R
import com.learncbse.maths12.data.DataSource
import com.learncbse.maths12.data.models.Exercice
import com.learncbse.maths12.ui.main.ExercicesAdapter
import com.learncbse.maths12.ui.view_doc.PdfViewActivity
import kotlinx.android.synthetic.main.activity_exercices_detail.*



class ExercicesDetailActivity : AppCompatActivity(), (Exercice) -> Unit {

    private lateinit var mInterstitialAd: InterstitialAd


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercices_detail)

        toolbar.title = "Solution"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back)
        toolbar.setNavigationOnClickListener{
            finish()
        }

        val exerciceName = intent.getStringExtra("NAME")
        val exerciceId = intent.getIntExtra("ID", 0)
        val subExercicesData = DataSource.subExercices[exerciceId]

        // Setup exercices Adapter
        val adapter = ExercicesAdapter(subExercicesData, this)
        recyclerview_exercices_detail.layoutManager = LinearLayoutManager(this)
        recyclerview_exercices_detail.adapter = adapter

        chapter_name.text = exerciceName
        val chapterNum = exerciceId+1
        chpter_number.text = "Chapter $chapterNum"

        val adRequest = AdRequest.Builder().build()
        erercise_ad.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = resources.getString(R.string.interstitial_id)

        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }



    override fun invoke(exercice: Exercice) {
        val exerciceDocName = exercice.exerciceDescription

        val i = Intent(this, PdfViewActivity::class.java)//this one here?
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {

                    Log.d("ads++++++++","no problem")
                    i.putExtra(PdfViewActivity.PDF_DOC_NAME, exerciceDocName)
                    startActivity( i)
                }
            }
        }else
        {

            Log.d("ads++++++++"," problem")
            i.putExtra(PdfViewActivity.PDF_DOC_NAME, exerciceDocName)
            startActivity( i)
        }

    }

}