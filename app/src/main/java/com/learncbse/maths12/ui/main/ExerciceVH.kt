package com.learncbse.maths12.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.learncbse.maths12.data.models.Exercice
import kotlinx.android.synthetic.main.row_excersice_0.view.*

/**
 * Created by Pedro Massango on 1/19/18.
 */
class ExerciceVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bindViews(exercice: Exercice) {
        with(view) {
            view.tv_title.text = exercice.exerciceName
            when (exercice.exerciceDescription.isEmpty() || exercice.exerciceDescription.endsWith(".pdf")) {
            }
        }

    }
}