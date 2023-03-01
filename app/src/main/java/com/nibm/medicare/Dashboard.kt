package com.nibm.medicare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.adapters.CategoriesAdapater
import com.nibm.medicare.models.Categories

class Dashboard : AppCompatActivity() {
    private lateinit var categoriesRV : RecyclerView
    private lateinit var categoryList : ArrayList<Categories>
    private lateinit var categoriesAdapater: CategoriesAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        categoriesRV = findViewById(R.id.categoriesRV)
        categoriesRV.setHasFixedSize(true)
        categoriesRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)

        categoryList = ArrayList()

        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))

        categoriesAdapater = CategoriesAdapater(categoryList)
        categoriesRV.adapter = categoriesAdapater
    }
}