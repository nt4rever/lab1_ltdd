package com.example.dice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage_1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage_1 = findViewById(R.id.dice_image_1)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.count_up_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        countUpButton.setOnClickListener {
            countUp()
        }
        resetButton.setOnClickListener {
            reset()
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        var dice_value: Int = getRandomInt()
        var dice_value_1: Int = getRandomInt()
        diceImage.setImageResource(getRandomDiceImage(dice_value))
        diceImage_1.setImageResource(getRandomDiceImage(dice_value_1))

        resultText.text = (dice_value + dice_value_1).toString()
        //        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            var resultInt: Int = resultText.text.toString().toInt()
            if (resultInt < 12) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Hello World!"
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage_1.setImageResource(R.drawable.dice_1)
        Toast.makeText(this, "Reset to default", Toast.LENGTH_SHORT).show()
    }

    private fun getRandomInt(): Int {
        return (1..6).random()
    }

    private fun getRandomDiceImage(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}