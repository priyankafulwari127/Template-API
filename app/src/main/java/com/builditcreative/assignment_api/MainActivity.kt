package com.builditcreative.assignment_api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val skipButton = findViewById<MaterialButton>(R.id.skipIntroButton)
        val nextButton = findViewById<ImageButton>(R.id.nextIntroButton)
        val titleText = findViewById<TextView>(R.id.titleText)
        val image1 = findViewById<ImageView>(R.id.ScreenOneImage)
        val progressbar1 = findViewById<ProgressBar>(R.id.progressbar1)

        skipButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
        }

        nextButton.setOnClickListener {
            when (currentPage) {
                0 -> {
                    titleText.text = "Our Mission"
                    currentPage++
                    progressbar1.progress = 60
                    image1.setImageResource(R.drawable.pana)
                }
                1 -> {
                    titleText.text = "Our Vision"
                    currentPage++
                    progressbar1.progress = 100
                    image1.setImageResource(R.drawable.bro)
                }
                2 -> {
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                }
            }
        }

    }
}