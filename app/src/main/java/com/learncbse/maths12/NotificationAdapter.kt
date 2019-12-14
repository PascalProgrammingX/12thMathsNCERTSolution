package com.learncbse.maths12

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learncbse.maths12.R
import com.learncbse.maths12.fireBaseSettings.Config
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.notification_row.view.*

class NotificationAdapter (var notification : ArrayList<Config>, val context: Context) : RecyclerView.Adapter<NotificationAdapter.VideoHolder>()  {

    var onItemClick: ((Config) -> Unit)? = null
    var onDeleteClick: ((Config , Int) -> Unit)? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotificationAdapter.VideoHolder {
        return VideoHolder(LayoutInflater.from(context).inflate(R.layout.notification_row,p0,false))

    }

    override fun getItemCount() = notification.size

    override fun onBindViewHolder(p0: NotificationAdapter.VideoHolder, p1: Int) {

        p0.title.text = notification[p1].title
       //  p0.content.text = notification[p1].content
        if (notification[p1].imageUrl != null)
        {
            Picasso.get().load(notification[p1].imageUrl).into(p0.imageView)
        }

    }


    //1
    inner class VideoHolder(v: View) : RecyclerView.ViewHolder(v) {
        //2
        private var view: View = v
        private var mConfig: Config? = null

        var title = view.row_title
        var imageView = view.row_imageView
        // var content = view.row_year
        var delIcon = view.rowDelete


        //3
        init {
            view.setOnClickListener{
                onItemClick?.invoke(notification[adapterPosition])
            }
            delIcon.setOnClickListener {
                onDeleteClick?.invoke(notification[adapterPosition],adapterPosition)
            }
        }
    }
    fun updateVideoList(mConfig : ArrayList<Config>){
        notification = ArrayList<Config>()
        notification.addAll(mConfig)
        notifyDataSetChanged()
    }
}
