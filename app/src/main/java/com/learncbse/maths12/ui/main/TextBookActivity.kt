package com.learncbse.maths12.ui.main


import android.annotation.SuppressLint
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
import android.util.Log
import android.view.View
import com.google.firebase.messaging.FirebaseMessaging
import com.learncbse.maths12.R
import com.learncbse.maths12.data.OthersDataSource
import com.learncbse.maths12.data.models.OthersModel
import com.learncbse.maths12.ui.view_doc.OthersPdfActivity
import kotlinx.android.synthetic.main.activity_textbooks.*
import kotlinx.android.synthetic.main.downloading_dialog.view.*
import java.io.File
import java.util.*


class TextBookActivity : AppCompatActivity(), (OthersModel) -> Unit {

    private val onDownloadComplete = object: BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (downloadID == id)
            {
                val action = intent.action
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE == action)
                {
                    downloadComplete = true
                    alertDialog.dismiss()
                    openPdf()
                    //   Toast.makeText(this, "Download complete", Toast.LENGTH_SHORT).show
//                    val manager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//                    val q = DownloadManager.Query()
//                    val c = manager.query(q)
//                    if (c.moveToFirst())
//                    {
//                        do
//                        {
//                            val downloadPathUri = c.getString(c.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
//                            Log.e("PDF_PATH","path"+downloadPathUri)
//                            pdfPathToOpen = "$downloadPathUri$pdfName.pdf"
//                            openPdf()
//                        }
//                        while (c.moveToNext())
//                    }
//                    else
//                    {
//
//                    }
//                    c.close()
                }
            }
        }
    }

    var downloadID:Long = 0
    var pdfPathToOpen: String? = ""
    var pdfName: String = ""
    lateinit var alertDialog:AlertDialog
    var downloadComplete: Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textbooks)
        toolbar.title = "TextBooks"
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back)
        toolbar.setNavigationOnClickListener{
            finish()
        }

        // Setup recyclerView
        val othersAdapter = OthersAdapter(OthersDataSource.pdfUrls, this)
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
        pdfName = url.exerciceName
        //val file  = File("")
        val file = File(Environment.getExternalStorageDirectory() , "/12thNCERTSolution/TextBook$pdfName.pdf")
        Log.e("FILE_PATH_Already Exist",file.absolutePath)
        if (!file.exists()){
            download(url)
        }else{
            pdfPathToOpen = file.absolutePath
            pdfName = url.exerciceName
            openPdf()
        }
    }



    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun download(url: OthersModel) {
        // This is where the pdf is been saved.
        val file = File(Environment.getExternalStorageDirectory() , "/12thNCERTSolution/TextBook") // Here is the folder name.
        val pdfUrl = url.urls
        //downloadedPath = "/12thNCERTSolution" + url.exerciceName + ".pdf"
        val downloadManager = this.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
        val request = DownloadManager.Request(Uri.parse(pdfUrl))
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
                .setDestinationUri(Uri.fromFile(file))
                .setDestinationInExternalPublicDir("/12thNCERTSolution/TextBook",url.exerciceName + ".pdf")
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
        pdfPathToOpen = file.absolutePath+"/"+url.exerciceName + ".pdf"
        pdfName = url.exerciceName

        //downloadManager.enqueue(request)
        downloadID = Objects.requireNonNull(downloadManager).enqueue(request)
        registerReceiver(onDownloadComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val customDialog: View = layoutInflater.inflate(R.layout.downloading_dialog, null)
        val emojiCode = 0x1F609
        val someText ="This download might take a while depending on your internet speed."
        customDialog.downloadingText.setText(someText + getEmojiByUnicode(emojiCode) )
        builder.setView(customDialog)
        alertDialog =  builder.show()
    }



    fun getEmojiByUnicode(unicode: Int): String {
        return String(Character.toChars(unicode))
    }


    private fun openPdf(){
        Log.e("PDF_DETAILS",pdfPathToOpen)
        val intent = Intent(this, OthersPdfActivity::class.java)
        intent.putExtra(OthersPdfActivity.PDF_DOC_NAME, "$pdfPathToOpen")
        intent.putExtra("PDF_NAME", pdfName)
        startActivity(intent)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
