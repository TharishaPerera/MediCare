package com.nibm.medicare

import android.content.ComponentCallbacks
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.android.volley.toolbox.Volley
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class VerificationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

//    private var generatedOTP : Int = 0
//    private var mobileNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

//        val bundle = intent.extras
//        if (bundle != null){
//            generatedOTP = bundle.getInt("OTP")
//            mobileNumber = bundle.getString("mobileNumber").toString()
//        }

        FirebaseApp.initializeApp(this)

        auth = Firebase.auth

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d(TAG, "onVerificationCompleted:$credential")
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w(TAG, "onVerificationFailed", e)

                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

                // Show a message and update the UI
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d(TAG, "onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                resendToken = token
            }
        }

        var editTextPhone : EditText = findViewById(R.id.editTextPhone)
        var editTextPhone2 : EditText = findViewById(R.id.editTextPhone2)
        var sendOTPButton: Button = findViewById(R.id.sendOTPButton)
        var verifyButton : Button = findViewById(R.id.verifyButton)

        sendOTPButton.setOnClickListener{
            startPhoneNumberVerification(editTextPhone!!.text.toString())
        }

        verifyButton.setOnClickListener {
            verifyPhoneNumberWithCode(storedVerificationId, editTextPhone2!!.text.toString())
        }

    }

//    private fun resendCode() {
//        var sms = SMS()
//        val OTP = sms.generateOTP()
//        generatedOTP = OTP
//        try {
//            val queue = Volley.newRequestQueue(this)
//            sms.sendOTP(mobileNumber, OTP, queue)
//
//            Toast.makeText(applicationContext, "OTP Sent", Toast.LENGTH_LONG).show()
//        } catch (error: Exception) {
//            println(error.message)
//        }
//    }

//    private fun changeFocus(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText) {
//        enableDigi1(digi1, digi2, digi3, digi4)
//
//        digi1.addTextChangedListener {
//            if (digi1.text.isNotEmpty()){
//                digi2.isEnabled = true
//                digi2.requestFocus()
//            }
//        }
//        digi2.addTextChangedListener {
//            if (digi2.text.isNotEmpty()){
//                digi3.isEnabled = true
//                digi3.requestFocus()
//            }
//        }
//        digi3.addTextChangedListener {
//            if (digi3.text.isNotEmpty()){
//                digi4.isEnabled = true
//                digi4.requestFocus()
//            }
//        }
//    }
//
//    private fun clearFields(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText){
//        digi1.text = null
//        digi2.text = null
//        digi3.text = null
//        digi4.text = null
//    }
//
//    private fun enableDigi1(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText) {
//        digi1.requestFocus()
//        digi2.isEnabled = false
//        digi3.isEnabled = false
//        digi4.isEnabled = false
//    }

//    override fun onStart() {
//        super.onStart()
//        val currentUser = auth.currentUser
//        updateUI(currentUser)
//    }

    private fun startPhoneNumberVerification(phoneNumber: String){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyPhoneNumberWithCode(verificationId: String?, code: String){
        // Starting to verifying with the code
        val credential = PhoneAuthProvider.getCredential(verificationId!!, code)
        // End of verification
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    Log.d(TAG, "Signing in successful!")
                    val user = task.result?.user
                    updateUI(user)
                    Toast.makeText(this, "Welcome $user", Toast.LENGTH_SHORT).show()
                } else{
                    Log.w(TAG, "Signing in failed!", task.exception)
                    if(task.exception is FirebaseAuthInvalidCredentialsException){
                        // The verification code you entered was incorrect
                    }
                    // Change UI
                }
            }
    }

    private fun updateUI(user: FirebaseUser? = auth.currentUser){
        startActivity(Intent(this, Dashboard::class.java))
    }

    companion object{
        private const val TAG = "VerificationActivity"
    }

}