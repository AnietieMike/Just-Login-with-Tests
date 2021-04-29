package com.decagon.anietie.justlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {

    lateinit var profileIcon: ImageView
    lateinit var welcome: TextView
    lateinit var profileName: TextView
    lateinit var email: TextView
    lateinit var phone: TextView
    lateinit var gender: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        profileIcon = findViewById<ImageView>(R.id.imageView)
        welcome = findViewById<TextView>(R.id.tv_hello)
        profileName = findViewById<TextView>(R.id.tv_fullname)
        email = findViewById<TextView>(R.id.tv_email)
        phone = findViewById<TextView>(R.id.tv_phone)
        gender = findViewById<TextView>(R.id.tv_gender)

        profileName.text = intent.getStringExtra("name")
        email.text = intent.getStringExtra("email")
        phone.text = intent.getStringExtra("phone")
        gender.text = intent.getStringExtra("gender")

    }

}