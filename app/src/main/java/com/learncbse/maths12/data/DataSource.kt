package com.learncbse.maths12.data

import com.learncbse.maths12.R
import com.learncbse.maths12.data.models.Exercice

/**
 * Created by shashi singh on 1/16/18.
 */
object DataSource {

    //TODO: replace with original data

    // Categories for navigation header
    val categories = arrayListOf<Any>(


            Category("Notifications", R.drawable.ic_notification),
            "NCERT Solution Apps (ads)", // Header


            Category("12 Physics Solution", R.drawable.ic_study),
            Category("12 Chemistry Solution", R.drawable.ic_study),

            "More Useful Apps (ads)", // Header

            Category("H C Verma 2 Solution", R.drawable.ic_playstore2),
            Category("JEE Main Previous Year Paper", R.drawable.ic_playstore2),
            Category("JEE Advance Previous Year Paper", R.drawable.ic_playstore2),
            Category("NEET Previous Year Paper", R.drawable.ic_playstore2),




            "Communicate", // Header - Communicate

            Category("Contact Us", R.drawable.ic_email),
            Category("Share App", R.drawable.ic_share),
            Category("Rate App", R.drawable.ic_favourites),
            Category("Privacy Policy", R.drawable.ic_protection),
            Category("More Apps", R.drawable.ic_applications)

    )


    val exercices: ArrayList<Exercice>
        get() = arrayListOf(
                Exercice(0, "Relations and Functions",
                        "Exercises: ${subExercices[0].size}"),
                Exercice(0, "Inverse Trigonometric Functions",
                        "Exercises: ${subExercices[1].size}"),
                Exercice(0, "Matrices",
                        "Exercises: ${subExercices[2].size}"),
                Exercice(0, "Determinants",
                        "Exercises: ${subExercices[3].size}"),
                Exercice(0, "Continuity and Differentiability",
                        "Exercises: ${subExercices[4].size}"),
                Exercice(0, "Application of Derivatives",
                        "Exercises: ${subExercices[5].size}"),
                Exercice(0, "Integrals",
                        "Exercises: ${subExercices[6].size}"),
                Exercice(0, "Application of Integrals",
                        "Exercises: ${subExercices[7].size}"),
                Exercice(0, "Differential Equations",
                        "Exercises: ${subExercices[8].size}"),
                Exercice(0, "Vector Algebra",
                        "Exercises: ${subExercices[9].size}"),
                Exercice(0, "Three Dimensional Geometry",
                        "Exercises: ${subExercices[10].size}"),
                Exercice(0, "Linear Programming",
                        "Exercises: ${subExercices[11].size}"),

                Exercice(0, "Probability",
                        "Exercises: ${subExercices[12].size}")
        )

    val subExercices = arrayListOf<ArrayList<Exercice>>(

            // Real numbers
            arrayListOf(
                    Exercice(exerciceName = "Exercise 1.1", exerciceDescription = "Chapter-1-1.pdf"),
                    Exercice(exerciceName = "Exercise 1.2", exerciceDescription = "Chapter-1-2.pdf"),
                    Exercice(exerciceName = "Exercise 1.3", exerciceDescription = "Chapter-1-3.pdf"),
                    Exercice(exerciceName = "Exercise 1.4", exerciceDescription = "Chapter-1-4.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 1", exerciceDescription = "Chapter-1-5.pdf")
            ),
            // Polynomials
            arrayListOf(
                    Exercice(exerciceName = "Exercise 2.1", exerciceDescription = "Chapter-2-1.pdf"),
                    Exercice(exerciceName = "Exercise 2.2", exerciceDescription = "Chapter-2-2.pdf"),
                    Exercice(exerciceName = "Exercise 2.3", exerciceDescription = "Chapter-2-3.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 2", exerciceDescription = "Chapter-2-4.pdf")
            ),
            // Polynomials
            arrayListOf(
                    Exercice(exerciceName = "Exercise 3.1", exerciceDescription = "Chapter-3-1.pdf"),
                    Exercice(exerciceName = "Exercise 3.2", exerciceDescription = "Chapter-3-2.pdf"),
                    Exercice(exerciceName = "Exercise 3.3", exerciceDescription = "Chapter-3-3.pdf"),
                    Exercice(exerciceName = "Exercise 3.4", exerciceDescription = "Chapter-3-4.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 3", exerciceDescription = "Chapter-3-5.pdf")
            ),
            // Linear equations
            arrayListOf(
                    Exercice(exerciceName = "Exercise 4.1", exerciceDescription = "Chapter-4-1.pdf"),
                    Exercice(exerciceName = "Exercise 4.2", exerciceDescription = "Chapter-4-2.pdf"),
                    Exercice(exerciceName = "Exercise 4.3", exerciceDescription = "Chapter-4-3.pdf"),
                    Exercice(exerciceName = "Exercise 4.4", exerciceDescription = "Chapter-4-4.pdf"),
                    Exercice(exerciceName = "Exercise 4.5", exerciceDescription = "Chapter-4-5.pdf"),
                    Exercice(exerciceName = "Exercise 4.6", exerciceDescription = "Chapter-4-6.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 4", exerciceDescription = "Chapter-4-7.pdf")
            ),
            // Arithmetic
            arrayListOf(
                    Exercice(exerciceName = "Exercise 5.1", exerciceDescription = "Chapter-5-1.pdf"),
                    Exercice(exerciceName = "Exercise 5.2", exerciceDescription = "Chapter-5-2.pdf"),
                    Exercice(exerciceName = "Exercise 5.3", exerciceDescription = "Chapter-5-3.pdf"),
                    Exercice(exerciceName = "Exercise 5.4", exerciceDescription = "Chapter-5-4.pdf"),
                    Exercice(exerciceName = "Exercise 5.5", exerciceDescription = "Chapter-5-5.pdf"),
                    Exercice(exerciceName = "Exercise5.6", exerciceDescription = "Chapter-5-6.pdf"),
                    Exercice(exerciceName = "Exercise 5.7", exerciceDescription = "Chapter-5-7.pdf"),
                    Exercice(exerciceName = "Exercise 5.8", exerciceDescription = "Chapter-5-8.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 5", exerciceDescription = "Chapter-5-9.pdf")
            ),
            // Triangles
            arrayListOf(
                    Exercice(exerciceName = "Exercise 6.1", exerciceDescription = "Chapter-6-1.pdf"),
                    Exercice(exerciceName = "Exercise 6.2", exerciceDescription = "Chapter-6-2.pdf"),
                    Exercice(exerciceName = "Exercise 6.3", exerciceDescription = "Chapter-6-3.pdf"),
                    Exercice(exerciceName = "Exercise 6.4", exerciceDescription = "Chapter-6-4.pdf"),
                    Exercice(exerciceName = "Exercise 6.5", exerciceDescription = "Chapter-6-5.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 6", exerciceDescription = "Chapter-6-6.pdf")
            ),
            // 7
            arrayListOf(
                    Exercice(exerciceName = "Exercise 7.1", exerciceDescription = "Chapter-7-1.pdf"),
                    Exercice(exerciceName = "Exercise 7.2", exerciceDescription = "Chapter-7-2.pdf"),
                    Exercice(exerciceName = "Exercise 7.3", exerciceDescription = "Chapter-7-3.pdf"),
                    Exercice(exerciceName = "Exercise 7.4", exerciceDescription = "Chapter-7-4.pdf"),
                    Exercice(exerciceName = "Exercise 7.5", exerciceDescription = "Chapter-7-5.pdf"),
                    Exercice(exerciceName = "Exercise 7.6", exerciceDescription = "Chapter-7-6.pdf"),
                    Exercice(exerciceName = "Exercise 7.7", exerciceDescription = "Chapter-7-7.pdf"),
                    Exercice(exerciceName = "Exercise 7.8", exerciceDescription = "Chapter-7-8.pdf"),
                    Exercice(exerciceName = "Exercise 7.9", exerciceDescription = "Chapter-7-9.pdf"),
                    Exercice(exerciceName = "Exercise 7.10", exerciceDescription = "Chapter-7-10.pdf"),
                    Exercice(exerciceName = "Exercise 7.11", exerciceDescription = "Chapter-7-11.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 7", exerciceDescription = "Chapter-7-12.pdf")
            ),
            // 8
            arrayListOf(
                    Exercice(exerciceName = "Exercise 8.1", exerciceDescription = "Chapter-8-1.pdf"),
                    Exercice(exerciceName = "Exercise 8.2", exerciceDescription = "Chapter-8-2.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 8", exerciceDescription = "Chapter-8-3.pdf")
            ),
            // 9
            arrayListOf(
                    Exercice(exerciceName = "Exercise 9.1", exerciceDescription = "Chapter-9-1.pdf"),
                    Exercice(exerciceName = "Exercise 9.2", exerciceDescription = "Chapter-9-2.pdf"),
                    Exercice(exerciceName = "Exercise 9.3", exerciceDescription = "Chapter-9-3.pdf"),
                    Exercice(exerciceName = "Exercise 9.4", exerciceDescription = "Chapter-9-4.pdf"),
                    Exercice(exerciceName = "Exercise 9.5", exerciceDescription = "Chapter-9-5.pdf"),
                    Exercice(exerciceName = "Exercise 9.6", exerciceDescription = "Chapter-9-6.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 9", exerciceDescription = "Chapter-9-7.pdf")
            ),
            // 10
            arrayListOf(
                    Exercice(exerciceName = "Exercise 10.1", exerciceDescription = "Chapter-10-1.pdf"),
                    Exercice(exerciceName = "Exercise 10.2", exerciceDescription = "Chapter-10-2.pdf"),
                    Exercice(exerciceName = "Exercise 10.3", exerciceDescription = "Chapter-10-3.pdf"),
                    Exercice(exerciceName = "Exercise 10.4", exerciceDescription = "Chapter-10-4.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 10", exerciceDescription = "Chapter-10-5.pdf")
            ),
            // 11
            arrayListOf(
                    Exercice(exerciceName = "Exercise 11.1", exerciceDescription = "Chapter-11-1.pdf"),
                    Exercice(exerciceName = "Exercise 11.2", exerciceDescription = "Chapter-11-2.pdf"),
                    Exercice(exerciceName = "Exercise 11.3", exerciceDescription = "Chapter-11-3.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 11", exerciceDescription = "Chapter-11-4.pdf")
            ),
            // 12
            arrayListOf(
                    Exercice(exerciceName = "Exercise 12.1", exerciceDescription = "Chapter-12-1.pdf"),
                    Exercice(exerciceName = "Exercise 12.2", exerciceDescription = "Chapter-12-2.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 12", exerciceDescription = "Chapter-12-3.pdf")
            ),
            // 13
            arrayListOf(
                    Exercice(exerciceName = "Exercise 13.1", exerciceDescription = "Chapter-13-1.pdf"),
                    Exercice(exerciceName = "Exercise 13.2", exerciceDescription = "Chapter-13-2.pdf"),
                    Exercice(exerciceName = "Exercise 13.3", exerciceDescription = "Chapter-13-3.pdf"),
                    Exercice(exerciceName = "Exercise 13.4", exerciceDescription = "Chapter-13-4.pdf"),
                    Exercice(exerciceName = "Exercise 13.5", exerciceDescription = "Chapter-13-5.pdf"),
                    Exercice(exerciceName = "Miscellaneous Chapter 13", exerciceDescription = "Chapter-13-6.pdf")
            )



    )
}