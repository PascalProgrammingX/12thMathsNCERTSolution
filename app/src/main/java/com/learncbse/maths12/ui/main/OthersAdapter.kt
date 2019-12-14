package com.learncbse.maths12.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.learncbse.maths12.R
import com.learncbse.maths12.data.models.OthersModel
import java.util.ArrayList

class OthersAdapter(val pdfUrls: ArrayList<OthersModel>,
                    val iExerciceClickedListener: (OthersModel) -> Unit): RecyclerView.Adapter<OthersVH>(){



    override fun onBindViewHolder(holder: OthersVH, position: Int) {
        val pdf = pdfUrls[position]
        holder.bindViews(pdf)
        holder.itemView.setOnClickListener {
            pdf.othersId = holder.adapterPosition
            iExerciceClickedListener.invoke( pdf)

        }
    }

    override fun getItemCount(): Int = pdfUrls.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OthersVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_excersice_0, parent, false)
        return (OthersVH(view))
    }
}