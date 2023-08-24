package com.example.less12t

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val button = findViewById<Button>(R.id.sendButton)
        val mail = findViewById<EditText>(R.id.mail)
        val message = findViewById<EditText>(R.id.text)

        button.setOnClickListener {
            val addresses = mail.text.split(",".toRegex()).toTypedArray()

            val mailIntent = Intent(Intent.ACTION_SENDTO)
            mailIntent.type = "text/plain"
            mailIntent.setData(Uri.parse("mailto:"))
            mailIntent.putExtra(Intent.EXTRA_EMAIL, addresses)
            mailIntent.putExtra(Intent.EXTRA_TEXT, message.text.toString())
            startActivity(Intent.createChooser(mailIntent, "Choose Email client"))
        }
    }
}



