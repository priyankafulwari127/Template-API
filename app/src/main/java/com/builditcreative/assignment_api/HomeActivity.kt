package com.builditcreative.assignment_api

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activty)

        val feedButton = findViewById<MaterialButton>(R.id.feed)
        val uploadButton = findViewById<MaterialButton>(R.id.upload)

        feedButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, FeedActivity::class.java))
        }

        uploadButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, UploadActivity::class.java))
        }

    }

}