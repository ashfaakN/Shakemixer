package com.example.myapplicationshakemixer

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var timeButtonClicked = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val infoButton = findViewById<Button>(R.id.infobutton)
        infoButton.setOnClickListener {
            showPopup()
        }



        val strawberryButton: ImageButton = findViewById(R.id.strawberry)
        val chocolateButton: ImageButton = findViewById(R.id.choclate)
        val mangoButton: ImageButton = findViewById(R.id.mango)
        val vanillaButton: ImageButton = findViewById(R.id.vanilla)
        val option1TextView: TextView = findViewById(R.id.option1)
        val option2TextView: TextView = findViewById(R.id.option2)
        val mixButton: Button = findViewById(R.id.mix)
        val finalResult: TextView = findViewById(R.id.finalresult)

        val buttons = listOf(strawberryButton, chocolateButton, mangoButton, vanillaButton)

        buttons.forEach { button ->
            button.setOnClickListener {
                timeButtonClicked++
                if (timeButtonClicked == 1) {
                    option1TextView.setBackgroundResource(getFruitDrawable(button.id))
                } else if (timeButtonClicked == 2) {
                    option2TextView.setBackgroundResource(getFruitDrawable(button.id))
                    timeButtonClicked = 0
                }
            }
        }

        mixButton.setOnClickListener {
            val selectedFlavor1 = option1TextView.background.constantState
            val selectedFlavor2 = option2TextView.background.constantState

            val finalDrawableId = when {
                selectedFlavor1 == getDrawable(R.drawable.strawberryice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.mangoice)?.constantState ->
                    R.drawable.strawmango

                selectedFlavor1 == getDrawable(R.drawable.strawberryice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.chocolate)?.constantState ->
                    R.drawable.strawchoco

                selectedFlavor1 == getDrawable(R.drawable.strawberryice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.vanilaicecream)?.constantState ->
                    R.drawable.strawvanilla

                selectedFlavor1 == getDrawable(R.drawable.strawberryice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.strawberryice)?.constantState ->
                    R.drawable.strawberryice

                selectedFlavor1 == getDrawable(R.drawable.chocolate)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.strawberryice)?.constantState ->
                    R.drawable.strawchoco

                selectedFlavor1 == getDrawable(R.drawable.chocolate)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.chocolate)?.constantState ->
                    R.drawable.chocolate

                selectedFlavor1 == getDrawable(R.drawable.chocolate)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.mangoice)?.constantState ->
                    R.drawable.chocomango

                selectedFlavor1 == getDrawable(R.drawable.chocolate)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.vanilaicecream)?.constantState ->
                    R.drawable.vanillachoco

                selectedFlavor1 == getDrawable(R.drawable.mangoice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.strawberryice)?.constantState ->
                    R.drawable.strawmango

                selectedFlavor1 == getDrawable(R.drawable.mangoice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.chocolate)?.constantState ->
                    R.drawable.chocomango

                selectedFlavor1 == getDrawable(R.drawable.mangoice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.mangoice)?.constantState ->
                    R.drawable.mangoice

                selectedFlavor1 == getDrawable(R.drawable.mangoice)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.vanilaicecream)?.constantState ->
                    R.drawable.vanillamango

                selectedFlavor1 == getDrawable(R.drawable.vanilaicecream)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.strawberryice)?.constantState ->
                    R.drawable.strawvanilla

                selectedFlavor1 == getDrawable(R.drawable.vanilaicecream)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.chocolate)?.constantState ->
                    R.drawable.vanillachoco

                selectedFlavor1 == getDrawable(R.drawable.vanilaicecream)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.mangoice)?.constantState ->
                    R.drawable.vanillamango

                selectedFlavor1 == getDrawable(R.drawable.vanilaicecream)?.constantState &&
                        selectedFlavor2 == getDrawable(R.drawable.vanilaicecream)?.constantState ->
                    R.drawable.vanilaicecream

                else -> R.drawable.shapefield
            }

            finalResult.setBackgroundResource(finalDrawableId)
        }




    }
    private fun showPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_popup, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<Button>(R.id.closeButton).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun getFruitDrawable(buttonId: Int): Int {
        return when (buttonId) {
            R.id.strawberry -> R.drawable.strawberryice
            R.id.choclate -> R.drawable.chocolate
            R.id.mango -> R.drawable.mangoice
            R.id.vanilla -> R.drawable.vanilaicecream
            else -> R.drawable.shapefield
        }
    }



}