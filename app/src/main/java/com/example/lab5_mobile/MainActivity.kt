package com.example.lab5_mobile

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var saleSize = 0
    var timeHours = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val timeInput = findViewById<TextInputEditText>(R.id.Time_input);
        val saleBar = findViewById<SeekBar>(R.id.Sale_bar);
        val saleView = findViewById<TextView>(R.id.textView4);
        saleView.text = "Скидка: 0";


        if (savedInstanceState != null) {
            saleSize = savedInstanceState.getInt("SaleSize", 0)
            saleView.text = "Скидка: " + saleSize.toString() + "%";
            timeHours = savedInstanceState.getInt("Hours", 0)
        }


        saleBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                saleView.text = "Скидка: " + seek.progress.toString() + "%";
            }
            override fun onStartTrackingTouch(seek: SeekBar) {}
            override fun onStopTrackingTouch(seek: SeekBar) {
                saleSize = seek.progress;
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SaleSize", saleSize)
        outState.putInt("Hours", timeHours)
    }
}