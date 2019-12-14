package com.learncbse.maths12.ui.view_doc


import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.learncbse.maths12.R
import kotlinx.android.synthetic.main.activity_pdf_view.*


class PdfViewActivity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd

    companion object {
        const val PDF_DOC_NAME = "PDF_DOC_NAME"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_view)

        setSupportActionBar(pdf_toolbar)
        pdf_toolbar.setNavigationIcon(R.drawable.back)
        pdf_toolbar.setNavigationOnClickListener{
            finish()
        }

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = resources.getString(R.string.interstitial_id)

        mInterstitialAd.loadAd(AdRequest.Builder().build())

        // if null throw a exception
        requireNotNull(intent)

        // get the doc name
        val docName = intent.getStringExtra(PDF_DOC_NAME)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (docName.endsWith(".pdf")) {
                pdf_toolbar.title = docName.dropLast(4)
            } else {
               pdf_toolbar.title = docName
            }
        }
        requireNotNull(docName)



        Log.v("TCC", "DOC: $docName")

        pdfView.fromAsset(docName)
               .scrollHandle( DefaultScrollHandle(this))
                .password("Ls1027@##@a")
                .pageFling(false)
                .enableDoubletap(true)
                .autoSpacing(false)
                .enableAnnotationRendering(true)
                .enableSwipe(true)
                .onError {
                    Toast.makeText(this, "Failed to Load Document",Toast.LENGTH_LONG).show()
                }
                .load()
    }

    override fun onBackPressed() {

        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
            mInterstitialAd.adListener = object : AdListener() {
                override fun onAdClosed() {

                    Log.d("ads++++++++","no problem")
                    finish()

                }
            }
        }else
        {

            Log.d("ads++++++++"," problem")
            super.onBackPressed()

        }

    }
}
