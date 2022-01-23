package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var SeekBar= findViewById<SeekBar>(R.id.AgeBar)
        var ageBox= findViewById<EditText>(R.id.editAge)


        SeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var progressChangedValue = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
                ageBox.setText(progressChangedValue.toString())

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })


        calculate.setOnClickListener {


            var height = findViewById<EditText>(R.id.editHeight)
            var weight = findViewById<EditText>(R.id.editWeight)
            // Check if the height EditText and Weight EditText are not empty
            if (height.text.isNotEmpty() && weight.text.isNotEmpty()) {
                val height = (height.text.toString()).toInt()
                val weight = (weight.text.toString()).toInt()

                val Height_in_metre = height.toFloat() / 100
                var BMI = (weight.toFloat()/ (Height_in_metre * Height_in_metre)).toInt()

                // update the result text as per the bmi conditions
                if (BMI < 18.5) {
                    result.text = "Your BMI is : $BMI \n"+"You are Under Weight"
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    result.text = "Your BMI is : $BMI \n"+"You are Healthy"
                } else if (BMI >= 24.9 && BMI < 30) {
                    result.text = "Your BMI is : $BMI \n"+"You are Overweight"
                } else if (BMI >= 30) {
                    result.text = "Your BMI is : $BMI \n"+"You are Suffering from Obesity"
                }


            }
            else {
                Toast.makeText(this, "please enter the valid height and weight", Toast.LENGTH_SHORT).show()
            }
        }

    }


}