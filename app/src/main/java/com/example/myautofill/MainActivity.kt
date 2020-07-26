package com.example.myautofill

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView
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

        val htmlData =
            "<p><strong>Title</strong></p>\r\n\r\n<ul>\r\n\t<li>subtitle 1</li>\r\n\t<li>subtitle 2</li>\r\n\t<li>subtitle 3</li>\r\n\t<li>subtitle 4</li>\r\n\t<li>subtitle 5</li>\r\n</ul>\r\n"
        val tvHtml = findViewById<TextView>(R.id.tvHtml)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //tvHtml.text = Html.fromHtml(htmlData, Html.FROM_HTML_MODE_LEGACY)
        } else {
            //tvHtml.text = Html.fromHtml(htmlData)
        }

        val mWebView = findViewById<WebView>(R.id.mWebView)
        mWebView.loadDataWithBaseURL("", htmlData, "text/html", "UTF-8", "");
    }
}