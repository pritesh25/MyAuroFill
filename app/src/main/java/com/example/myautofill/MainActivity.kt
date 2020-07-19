package com.example.myautofill

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //require min api 23
        //val afm = getSystemService(AutofillManager::class.java)
        //afm.requestAutofill(etName)

        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)


        val etName = findViewById<TextInputEditText>(R.id.etName)


        val etPhone = findViewById<TextInputEditText>(R.id.etPhone)


        val etPostalCode = findViewById<TextInputEditText>(R.id.etPostalCode)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            etEmail.setAutofillHints(View.AUTOFILL_HINT_EMAIL_ADDRESS)
            etName.setAutofillHints(View.AUTOFILL_HINT_NAME)
            etPhone.setAutofillHints(View.AUTOFILL_HINT_PHONE)
            etPostalCode.setAutofillHints(View.AUTOFILL_HINT_POSTAL_CODE)
        }
    }
}