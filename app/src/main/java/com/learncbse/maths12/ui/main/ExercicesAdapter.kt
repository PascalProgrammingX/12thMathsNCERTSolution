package com.learncbse.maths12.ui.main


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.learncbse.maths12.R
import com.learncbse.maths12.data.models.Exercice

/**
 * Created by shashi singh  on 1/19/18.
 */
class ExercicesAdapter(val exercices: ArrayList<Exercice>,
                        val iExerciceClickedListener: (Exercice) -> Unit): RecyclerView.Adapter<ExerciceVH>() {

    var chapterNumber:Int = 0

    override fun onBindViewHolder(holder: ExerciceVH, position: Int) {
        val exercice = exercices[position]
        holder.bindViews(exercice)
        holder.itemView.setOnClickListener {
            exercice.exerciceId = holder.adapterPosition
            iExerciceClickedListener.invoke( exercice)

            chapterNumber = holder.adapterPosition

        }
    }

    override fun getItemCount(): Int = exercices.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciceVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_excersice_0, parent, false)
        return (ExerciceVH(view))
    }
}