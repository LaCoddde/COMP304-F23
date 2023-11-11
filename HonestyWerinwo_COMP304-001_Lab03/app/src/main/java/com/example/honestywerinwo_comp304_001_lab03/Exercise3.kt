package com.example.honestywerinwo_comp304_001_lab03

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class Exercise3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise3)

        val exitBtn = findViewById<Button>(R.id.buttonExit)

        exitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // We will animate the Earth ImageView
        val earthImageView = findViewById<ImageView>(R.id.earth_pic)

        // Load the animation for Earth to revolve around the Sun
        val revolutionAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.revolve_around_sun)

        // Start the animation
        earthImageView.startAnimation(revolutionAnimation)
    }
}