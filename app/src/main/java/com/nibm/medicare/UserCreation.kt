package com.nibm.medicare

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.nibm.medicare.models.User
import com.nibm.medicare.service.RestApiService
import java.util.*

class UserCreation : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_creation)

        setGendersSpinner()
        setBloodTypesSpinner()
        showDatePickerDialog()

        handleNavigation()

        var createUserButton : Button = findViewById(R.id.btn_create_user)
        createUserButton.setOnClickListener {
            try{
                addUserToDatabase()
                Toast.makeText(this, "User created successfully", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, VerificationActivity::class.java)
                //intent.putExtra("Mobile Number", mobileNumber.text.toString())
                startActivity(intent)
            }
            catch (e: Exception){
                Toast.makeText(this, "Error creating user. Please try again.", Toast.LENGTH_SHORT).show()
                Log.d("Error", "Error creating new user")
            }
        }
    }

    private fun setGendersSpinner(){
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
    }

    private fun setBloodTypesSpinner(){
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
    }

    fun showDatePickerDialog(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        var dobEditText : EditText = findViewById(R.id.txt_dob)

        dobEditText.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                dobEditText.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
            }, year, month, day)
            datePickerDialog.show()
        }
    }

    private fun addUserToDatabase(){

        var mobileNumber : EditText = findViewById(R.id.txt_mobile_number)
        var firstName : EditText = findViewById(R.id.txt_firstname)
        var lastName : EditText = findViewById(R.id.txt_lastname)
        var dateOfBirth : EditText = findViewById(R.id.txt_dob)
        var genderSpinner : Spinner = findViewById(R.id.gender_spinner)
        var bloodTypeSpinner : Spinner = findViewById(R.id.blood_type_spinner)
        var address : EditText = findViewById(R.id.txt_address)

        val apiService = RestApiService()
        val userInfo = User(
            uMobile = mobileNumber.text.toString().substring(1),
            uFirstName = firstName.text.toString(),
            uLastName = lastName.text.toString(),
            dob = dateOfBirth.text.toString(),
            uGender = genderSpinner.selectedItem.toString(),
            uBloodGroup = bloodTypeSpinner.selectedItem.toString(),
            uAddress = address.text.toString()
        )

        apiService.addUser(userInfo) {
            if (it?.uMobile != null) {
            } else {
                Log.d("Error", "Error creating new user")
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        parent?.getItemAtPosition(pos)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun handleNavigation(){
        var backIcon : ImageView = findViewById(R.id.back)
        backIcon.setOnClickListener{
            var intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }



}