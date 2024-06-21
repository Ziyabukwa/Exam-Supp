package com.example.examsupp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailView : AppCompatActivity() {
    val days = arrayOf<String>( // (IIE, 2024)
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )
    val min = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0)// (IIE, 2024)
    val max = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0) // (IIE, 2024)
    val condition = arrayOf<String>("", "", "", "", "", "", "") // (IIE, 2024)
    var counter = 0 // (IIE, 2024)

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view)


        val displayDays = findViewById<TextView>(R.id.displayDays) //(IIE, 2024)
        val displayMin = findViewById<TextView>(R.id.displayMin)//(IIE, 2024)
        val displayMax = findViewById<TextView>(R.id.displayMax)//(IIE, 2024)
        val displayWeather = findViewById<TextView>(R.id.displayWeather)//(IIE, 2024)


        val bundle: Bundle? = intent.extras //(TechnicalCode, 2021)
        val buttonBack = findViewById<Button>(R.id.buttonBack)//(TechnicalCode, 2021)
        val days = intent.getStringExtra("theDays") //(TechnicalCode, 2021)
        val min = intent.getStringExtra("theMin")//(TechnicalCode, 2021)
        val theMin = min!!.toInt() //(TechnicalCode, 2021)
        val max = intent.getStringExtra("theMax") //(TechnicalCode, 2021)
        val theMax = max!!.toInt() //(TechnicalCode, 2021)
        val condition = intent.getStringExtra("theNotes") //(TechnicalCode, 2021)

        var counter = 1
        var inputOne = ""
        var inputTwo = ""
        var inputThree = ""
        var inputFour = ""


        while (counter <= 7){ //(IIE, 2024)
            inputOne += "${days?.get(counter)}\n"
                if (counter <= 7){ //(IIE,2024)
                    inputTwo += "${min[counter]}\n"
                    inputThree += "${max[counter]}\n"
                    inputFour += "${condition?.get(counter)}\n"
                }
                displayDays.text = inputOne
                displayMin.text = inputTwo
                displayMax.text = inputThree
                displayWeather.text = inputFour


        }


        buttonBack.setOnClickListener() {
            onBackPressed() //(StackOverFlow , 2018)
        }
    }
}
// Stack Overflow. 2018. Kotlin:Variable 'results' must be initialized. [Online]. Available at: https://stackoverflow.com/questions/49199281/kotlin-variable-result-must-be-initialized [Accessed 03 April 2024].
// The IIE. 2024. Introduction to Mobile Applications Developement[IMAD5112 Module Outline]. The Independent Institute of Education: Unpublished.
// How to pass values to the next activity - Technical Coding. 2021. [Online]. Available at: https://youtu.be/Yi8mxXsroJ4?si=s8vaOeUT2c83crF9 [Accessed 10 June 2024].

