package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.adapters.CategoriesAdapater
import com.nibm.medicare.adapters.QuickActionItemAdapter
import com.nibm.medicare.models.Categories
import com.nibm.medicare.models.QuickActionItem

class Dashboard : AppCompatActivity() {
    private lateinit var categoriesRV : RecyclerView
    private lateinit var categoryList : ArrayList<Categories>
    private lateinit var categoriesAdapater: CategoriesAdapater

    private lateinit var quickActionRV : RecyclerView
    private lateinit var quickActionItemList : ArrayList<QuickActionItem>
    private lateinit var quickActionItemAdapter : QuickActionItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setCategories();
        setQuickActionItems();
        handleNavigation();
    }

    private fun setQuickActionItems() {
        quickActionRV = findViewById(R.id.quickActionsRV)
        quickActionRV.setHasFixedSize(true)
        quickActionRV.layoutManager= GridLayoutManager(this, 2)

        quickActionItemList = ArrayList()

        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))
        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))
        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))
        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))
        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))
        quickActionItemList.add(QuickActionItem(R.drawable.appointment_img_lg, "Appointments"))

        quickActionItemAdapter = QuickActionItemAdapter(quickActionItemList)
        quickActionRV.adapter = quickActionItemAdapter
    }

    private fun setCategories() {
        categoriesRV = findViewById(R.id.categoriesRV)
        categoriesRV.setHasFixedSize(true)
        categoriesRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        categoryList = ArrayList()

        // set data
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))
        categoryList.add(Categories(R.drawable.appointment_img_lg, "Appointments"))

        categoriesAdapater = CategoriesAdapater(categoryList)
        categoriesRV.adapter = categoriesAdapater
    }

    private fun handleNavigation(){
        var btnAppointments : ImageView
        var btnRecords : ImageView
        var btnSettings : ImageView

        btnAppointments = findViewById(R.id.btn_appointments)
        btnRecords = findViewById(R.id.btn_records)
        btnSettings = findViewById(R.id.btn_settings)

        btnAppointments.setOnClickListener {
            var intent = Intent(this, Appointments::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            var intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}