package com.learncbse.maths12.ui.view_doc


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.scroll.ScrollHandle
import com.learncbse.maths12.R
import kotlinx.android.synthetic.main.activity_others_pdf.*
import java.io.File


class OthersPdfActivity : AppCompatActivity() {

    companion object {
        const val PDF_DOC_NAME = "PDF_DOC_NAME"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_others_pdf)

        pdf_toolbar.title = intent.getStringExtra("PDF_NAME")
        setSupportActionBar(pdf_toolbar)
        pdf_toolbar.setNavigationIcon(R.drawable.back)
        pdf_toolbar.setNavigationOnClickListener{
            finish()
        }

        openPdf()

    }


    private fun openPdf(){
        val docName = intent.getStringExtra(PDF_DOC_NAME)
        pdfView.fromFile(File(docName))
                .scrollHandle(DefaultScrollHandle(this) as ScrollHandle?)
                .password("Ls1027@##@a")
                .onError {
                    Toast.makeText(this, "Failed to Load Document", Toast.LENGTH_LONG).show()
                }
                .load()
    }


    override fun onBackPressed() {
        if (pdfView.isShown){
            finish()
        }else {
            super.onBackPressed()
        }
    }
}
