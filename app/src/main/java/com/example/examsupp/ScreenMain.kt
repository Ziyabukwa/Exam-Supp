package com.example.examsupp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class ScreenMain : AppCompatActivity() {

    val days = arrayOf<String>(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    )
    val min = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0)
    val max = arrayOf<Int>(0, 0, 0, 0, 0, 0, 0)
    val condition = arrayOf<String>("", "", "", "", "", "", "")
    var counter = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonAverage = findViewById<Button>(R.id.buttonAverage)
        val buttonDetails = findViewById<Button>(R.id.buttonDetail)
        val buttonExit = findViewById<Button>(R.id.buttonExit)
        val editTextDays = findViewById<EditText>(R.id.editTextDays)
        val editTextMin = findViewById<EditText>(R.id.editTextMin)
        val editTextMax = findViewById<EditText>(R.id.editTextMax)
        val editTextCondition = findViewById<EditText>(R.id.editTextCondition)
        var textViewDay = findViewById<TextView>(R.id.textDay)
        val textViewMin = findViewById<TextView>(R.id.textViewMin)
        val textViewMax = findViewById<TextView>(R.id.textViewMax)
        val textViewWeather = findViewById<TextView>(R.id.textViewWeather)
        val textViewAverage = findViewById<TextView>(R.id.textViewAverage)
        val textViewError = findViewById<TextView>(R.id.textViewError)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        buttonDetails.setOnClickListener() {
            val intent = Intent(this, DetailView::class.java) // (Foysal Tech, 2021)
            intent.putExtra("theDays",days)// (Foysal Tech, 2021)
            intent.putExtra("theMax", min) // (Foysal Tech, 2021)
            intent.putExtra("theMin", max) // (Foysal Tech, 2021)
            intent.putExtra("theCondition",condition) // (Foysal Tech, 2021)
            startActivity(intent)// (Foysal Tech, 2021)
        }

        buttonSave.setOnClickListener() {
            val daysOne = editTextDays.text.toString()
            val minOne = editTextMin.text.toString().toInt()
            val maxOne = editTextMax.text.toString().toInt()
            val conditionOne = editTextCondition.text.toString()

            days[counter] = daysOne
            min[counter] = minOne
            max[counter] = maxOne
            condition[counter] = conditionOne
            counter++

            var display = ""
            var displayTwo = ""
            var displayThree = ""
            var displayFour = ""
            var count = 0

            while (count < 7) { // (IIE, 2024)
                display += "${days[count]}\n"
                if (count < 7) { //(IIE, 2024)
                    displayTwo += "${min[count]}\n"
                    displayThree += "${max[count]}\n"
                    displayFour += "${condition[count]}\n"
                    count++
                }
                textViewDay.text = display
                textViewMin.text = displayTwo
                textViewMax.text = displayThree
                textViewWeather.text = displayFour
            }
            if (counter == 7) { //(IIE, 2024)
                textViewError.text = "Array is full"
            }

        }

        buttonAverage.setOnClickListener() {
            var sum: Int = 0 // (IIE, 2024)
            var sumTwo: Int = 0 // (IIE, 2024)
            counter = 0 // (IIE, 2024)
            var average = 0 // (IIE, 2024)


            while (counter < 7) { // (IIE, 2024)
                sum += min[counter]
                sumTwo += max[counter]
                counter++
            }
            average = (sum + sumTwo) / 7 // (IIE, 2024)
            textViewAverage.text = "The average is $average" // (IIE, 2024)

        }
        buttonClear.setOnClickListener() { // (IIE, 2024)
            textViewDay.text = editTextDays.text.clear().toString()
            textViewMin.text = editTextDays.text.clear().toString()
            textViewMax.text = editTextMax.text.clear().toString()
            textViewWeather.text = editTextCondition.text.clear().toString()
        }

        buttonExit.setOnClickListener() {
            finishAffinity() // (stackOverFlow , 2018)
        }

    }
}
// Stack Overflow. 2018. Kotlin:Variable 'results' must be initialized. [Online]. Available at: https://stackoverflow.com/questions/49199281/kotlin-variable-result-must-be-initialized [Accessed 03 April 2024].
// The IIE. 2024. Introduction to Mobile Applications Developement[IMAD5112 Module Outline]. The Independent Institute of Education: Unpublished.
// How to pass code to the next screen? - Foysal Tech. 2021. YouTube video, added by Foysal Tech. Available at: https://youtu.be/Rhx_UXyaQLA?si=zeZkZ36m6NGqZNEF [Accessed 10 June 2024]
// The IIE.2024. Introduction to Quantative Thinking and Techniques[IQTT5111 Module Outline]. The Independent Institute of Education: Unpublished.





