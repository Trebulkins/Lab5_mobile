package com.example.lab5_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val saleSize = intent.getIntExtra("SaleSize", 0)
        val hours = intent.getIntExtra("Hours", 0)

        val buttonY = findViewById<Button>(R.id.YESb);
        val buttonN = findViewById<Button>(R.id.NOb);

        val saleText = findViewById<TextView>(R.id.SaleSize);
        val paymentText = findViewById<TextView>(R.id.PaymentSize);


    }
}