package com.learncbse.maths12.ui.main


import android.app.AlertDialog
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.messaging.FirebaseMessaging
import com.learncbse.maths12.R
import com.learncbse.maths12.data.OthersDataSource
import com.learncbse.maths12.data.models.OthersModel
import com.learncbse.maths12.ui.view_doc.OthersPdfActivity
import kotlinx.android.synthetic.main.activity_formula.*
import java.io.File
import java.util.*


class FormulaActivity : AppCompatActivity(), (OthersModel) -> Unit {

    private val onDownloadComplete = object: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (downloadID == id)
            {
                val action = intent.action
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE == action)
                {
                    val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    val q = DownloadManager.Query()
                    val c = manager.query(q)
                    if (c.moveToFirst())
                    {
                        do
                        {
                            val name = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME))
                            pdfPathToOpen = name
                            openPdf()
                        }
                        while (c.moveToNext())
                    }
                    else
                    {

                    }
                    c.close()
                }
            }
        }
    }

    var downloadID:Long = 0
    var pdfPathToOpen: String? = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbooks)
        toolbar.title = "Formula"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back)
        toolbar.setNavigationOnClickListener{
            finish()
        }

        // Setup recyclerView
        val othersAdapter = OthersAdapter(OthersDataSource.formulaPdfUrls, this)
        recyclerview_main.layoutManager = LinearLayoutManager(this)
        recyclerview_main.adapter = othersAdapter

        FirebaseMessaging.getInstance().subscribeToTopic("maths12")
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {

                    }
                }
    }




    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun invoke(url: OthersModel) {
        val file : File = File("")
        if (!file.exists()){
            download(url)
        }else{
            val intent = Intent(this, OthersPdfActivity::class.java)
            intent.putExtra(OthersPdfActivity.PDF_DOC_NAME, file)
            startActivity(intent)
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun download(url: OthersModel) {
        val file = File(Environment.getExternalStorageDirectory() , "/12thNCERTSolution")
        val pdfUrl = url.urls
        val request = DownloadManager.Request(Uri.parse(pdfUrl))
                .setTitle("12thNCERTSolution")
                .setDescription("Downloading...")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                .setDestinationUri(Uri.fromFile(file))
                .setDestinationInExternalPublicDir("/12thNCERTSolution", "12thNCERTSolution " + "12thNCERTSolution 1" + ".pdf")
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
        val downloadManager = this.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        downloadID = Objects.requireNonNull(downloadManager).enqueue(request)
        registerReceiver(onDownloadComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Downloading...")
        builder.setMessage("Please wait! \n  Processing....")
        builder.setCancelable(true)
        //  dialog = builder.create()
        builder.show()
    }


    private fun openPdf(){
        val intent = Intent(this, OthersPdfActivity::class.java)
        intent.putExtra(OthersPdfActivity.PDF_DOC_NAME, pdfPathToOpen)
        startActivity(intent)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
