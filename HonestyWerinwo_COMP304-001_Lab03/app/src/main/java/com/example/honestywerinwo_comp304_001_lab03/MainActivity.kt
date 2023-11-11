package com.example.honestywerinwo_comp304_001_lab03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ex1 = findViewById<Button>(R.id.btnEx1)
        val ex2 = findViewById<Button>(R.id.btnEx2)
        val ex3 = findViewById<Button>(R.id.btnEx3)

        ex1.setOnClickListener {
            val intent = Intent(this, Exercise1::class.java)
            startActivity(intent)
        }

        ex2.setOnClickListener {
            val intent = Intent(this, Exercise2::class.java)
            startActivity(intent)
        }

        ex3.setOnClickListener {
            val intent = Intent(this, Exercise3::class.java)
            startActivity(intent)
        }



    }
}