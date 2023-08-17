package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * Esta Activity permite al usuario lanzar un dado y muestra el resultado
 * en pantalla.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Lanza el dado y muestra el resultado en pantalla
     */
    private fun rollDice() {
        //Crea un objeto "dado" con 6 caras y genera un resultado
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Muestra en pantalla el resultado
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
