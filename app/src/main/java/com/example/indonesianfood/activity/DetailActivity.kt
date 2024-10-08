package com.example.indonesianfood.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.indonesianfood.R
import com.example.indonesianfood.data.Food

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Detail Makanan"

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailOrigin: TextView = findViewById(R.id.tv_detail_origin)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)
        val bShare: Button = findViewById(R.id.action_share)

        @Suppress("DEPRECATION") val food = intent.getParcelableExtra<Food>("EXTRA_FOOD")

        if (food != null) {
            tvDetailName.text = food.name
            tvDetailOrigin.text = food.origin
            tvDetailDescription.text = food.description
            ivDetailPhoto.setImageResource(food.photo)

            bShare.setOnClickListener {
                val shareIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TITLE, "${food.name} - ${food.origin}")
                    putExtra(Intent.EXTRA_TEXT, food.description)
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Bagikan kepada"))
            }
        }
    }
}