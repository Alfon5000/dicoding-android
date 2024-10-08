package com.example.indonesianfood.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.indonesianfood.R
import com.example.indonesianfood.adapter.ListFoodAdapter
import com.example.indonesianfood.data.Food

class MainActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private val listFoods = ArrayList<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        listFoods.addAll(getListFoods())
        showRecyclerList()
    }

    private fun getListFoods(): ArrayList<Food> {
        val dataName = resources.getStringArray(R.array.foods_name_data)
        val dataOrigin = resources.getStringArray(R.array.foods_origin_data)
        val dataDescription = resources.getStringArray(R.array.foods_description_data)
        val dataPhoto = resources.obtainTypedArray(R.array.foods_photo_data)
        val listFood = ArrayList<Food>()

        for (i in dataName.indices) {
            val food = Food(dataName[i], dataOrigin[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listFood.add(food)
        }

        return listFood
    }

    private fun showRecyclerList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(listFoods)
        rvFoods.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(food: Food) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("EXTRA_FOOD", food)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intentToAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentToAbout)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}