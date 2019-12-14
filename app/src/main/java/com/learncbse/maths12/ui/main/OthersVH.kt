package com.learncbse.maths12.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.learncbse.maths12.data.models.OthersModel
import kotlinx.android.synthetic.main.row_excersice_0.view.*

class OthersVH (val view: View) : RecyclerView.ViewHolder(view) {


    fun bindViews(exercice: OthersModel) {
        with(view) {
            view.tv_title.text = exercice.exerciceName

        }

    }
}

