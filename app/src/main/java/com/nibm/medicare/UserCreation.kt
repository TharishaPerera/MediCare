package com.nibm.medicare

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import java.util.*

class UserCreation : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_creation)

        val genderSpinner: Spinner = findViewById(R.id.gender_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genderSpinner.adapter = adapter
        }

        genderSpinner.onItemSelectedListener = this

        val bloodTypeSpinner: Spinner = findViewById(R.id.blood_type_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.blood_type_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bloodTypeSpinner.adapter = adapter
        }

        bloodTypeSpinner.onItemSelectedListener = this

        var createUserButton : Button = findViewById(R.id.btn_create_user)
        createUserButton.setOnClickListener {
            // Enter the new user into database
            var intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }
    }

//    class GendersSpinner : AdapterView.OnItemSelectedListener{
//        override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
//            parent?.getItemAtPosition(pos)
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {
//            TODO("Not yet implemented")
//        }
//
//    }
//
//    class BloodGroupsSpinner : AdapterView.OnItemSelectedListener{
//        override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
//            parent?.getItemAtPosition(pos)
//        }
//
//        override fun onNothingSelected(parent: AdapterView<*>?) {
//            TODO("Not yet implemented")
//        }
//
//    }
//
//    class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

//        fun showDatePickerDialog(v: View) {
//            val newFragment = DatePickerFragment()
//            newFragment.show(supportFragmentManager, "datePicker")
//        }

//        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//            // Use the current date as the default date in the picker
//            val c = Calendar.getInstance()
//            val year = c.get(Calendar.YEAR)
//            val month = c.get(Calendar.MONTH)
//            val day = c.get(Calendar.DAY_OF_MONTH)
//
//            // Create a new instance of DatePickerDialog and return it
//            return DatePickerDialog(requireContext(), this, year, month, day)
//
//        }
//
//        override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
//            // Do something with the date chosen by the user
//        }
//    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        parent?.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}