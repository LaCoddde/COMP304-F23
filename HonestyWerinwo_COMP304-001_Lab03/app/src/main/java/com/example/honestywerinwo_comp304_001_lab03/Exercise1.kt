package com.example.honestywerinwo_comp304_001_lab03


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Selection.*
import android.view.KeyEvent
import android.view.View
import android.widget.*

private lateinit var customDrawingView: DrawingView
private lateinit var textViewYValue: TextView

private lateinit var radioGroup: RadioGroup
private lateinit var thicknessSpinner: Spinner

private var dx = 0f
private var dy = 0f
private val step = 10f
private var lastX = 0f
private var lastY = 0f

class Exercise1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise1)

        textViewYValue = findViewById(R.id.textViewYValue)
        customDrawingView = findViewById(R.id.customDrawingView)

        // Setup color chooser using RadioGroup
        radioGroup = findViewById(R.id.radioGroupColor)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonRed -> customDrawingView.setCurrentPaintColor(Color.RED)
                R.id.radioButtonYellow -> customDrawingView.setCurrentPaintColor(Color.YELLOW)
                R.id.radioButtonCyan -> customDrawingView.setCurrentPaintColor(Color.CYAN)
            }
        }

        // Setup thickness chooser
        thicknessSpinner = findViewById(R.id.thicknessSpinner)
        val thicknesses = arrayOf("5", "10", "15", "20", "25", "30")
        val thicknessAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, thicknesses)
        thicknessAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        thicknessSpinner.adapter = thicknessAdapter
        thicknessSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                val selectedThickness = thicknessSpinner.selectedItem.toString().toFloat()
                customDrawingView.setCurrentPaintStrokeWidth(selectedThickness)
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                customDrawingView.setCurrentPaintStrokeWidth(5f)
            }
        }

        // Arrow key button listeners
        findViewById<ImageButton>(R.id.buttonUp).setOnClickListener { moveUp() }
        findViewById<ImageButton>(R.id.buttonDown).setOnClickListener { moveDown() }
        findViewById<ImageButton>(R.id.buttonLeft).setOnClickListener { moveLeft() }
        findViewById<ImageButton>(R.id.buttonRight).setOnClickListener { moveRight() }

        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearCanvas() }
    }

    private fun clearCanvas() {
        customDrawingView.clearCanvas()
        textViewYValue.text = "y = "
        lastX = 0f
        lastY = 0f
    }

    private fun moveUp() {
        val newY = lastY - step
        customDrawingView.drawLine(lastX, lastY, lastX, newY)
        lastY = newY
        textViewYValue.text = "y = $lastY"
    }

    private fun moveDown() {
        val newY = lastY + step
        customDrawingView.drawLine(lastX, lastY, lastX, newY)
        lastY = newY
        textViewYValue.text = "y = $lastY"
    }

    private fun moveLeft() {
        val newX = lastX - step
        customDrawingView.drawLine(lastX, lastY, newX, lastY)
        lastX = newX
        textViewYValue.text = "y = $lastY"
    }

    private fun moveRight() {
        val newX = lastX + step
        customDrawingView.drawLine(lastX, lastY, newX, lastY)
        lastX = newX
        textViewYValue.text = "y = $lastY"
    }
}
