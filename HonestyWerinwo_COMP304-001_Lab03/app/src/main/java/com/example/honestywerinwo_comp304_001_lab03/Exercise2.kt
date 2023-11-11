package com.example.honestywerinwo_comp304_001_lab03


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

//private var  growthAnimation: AnimationDrawable = TODO()
private lateinit var growthAnimation: AnimationDrawable

class Exercise2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise2)

        val exitBtn: Button = findViewById(R.id.buttonExit)
        val imageViewPup: ImageView = findViewById(R.id.imageViewPup)

        // Set the image resource to the animation list
        imageViewPup.setImageResource(R.drawable.pop_animation)
        // Cast the drawable to AnimationDrawable
        val drawable = imageViewPup.drawable
        if (drawable is AnimationDrawable) {
            growthAnimation = drawable
        }

        exitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonStart: Button = findViewById(R.id.buttonStart)
        val buttonStop: Button = findViewById(R.id.buttonStop)

        buttonStart.setOnClickListener { startAnimation() }
        buttonStop.setOnClickListener { stopAnimation() }
    }

    private fun startAnimation() {
        if (::growthAnimation.isInitialized) {
            growthAnimation.start()
        } else {
            // Handle the case where growthAnimation is not initialized
        }
    }

    private fun stopAnimation() {
        if (::growthAnimation.isInitialized) {
            growthAnimation.stop()
        } else {
            // Handle the case where growthAnimation is not initialized
        }
    }
}