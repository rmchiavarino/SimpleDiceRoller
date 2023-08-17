package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

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

        //Hacemos un roll cuando arranca la app, asi no arranca en blanco
        rollDice()
    }

    /**
     * Lanza el dado y muestra el resultado en pantalla
     */
    private fun rollDice() {
        //Crea un objeto "dado" con 6 caras y genera un resultado
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Le asigna un drawableResource al ImageView que representa el resultado del dado
        val diceImage:ImageView = findViewById(R.id.imageView)
        val drawableResource = when(diceRoll) {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        //Actualizo la descripcion en texto de la imagen (Para personas no videntes):
        diceImage.contentDescription = diceRoll.toString()

        /**
         * Implementacion menos eficiente:
         *
        when(diceRoll) {
            1->diceImage.setImageResource(R.drawable.dice_1)
            2->diceImage.setImageResource(R.drawable.dice_2)
            3->diceImage.setImageResource(R.drawable.dice_3)
            4->diceImage.setImageResource(R.drawable.dice_4)
            5->diceImage.setImageResource(R.drawable.dice_5)
            6->diceImage.setImageResource(R.drawable.dice_6)
        }
        */
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
