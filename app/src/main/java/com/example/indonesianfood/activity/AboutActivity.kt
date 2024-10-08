package com.example.indonesianfood.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.indonesianfood.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Tentang Saya"
    }
}