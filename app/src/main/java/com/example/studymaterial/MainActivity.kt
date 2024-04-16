package com.example.studymaterial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gotoHomePage = findViewById<Button>(R.id.homepage)
        gotoHomePage.setOnClickListener{
            val intent = Intent(applicationContext, HomeScreen::class.java)
            startActivity(intent)
        }
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        // Check if user is logged in
        if (auth.currentUser != null) {
            // User is already logged in, navigate to TweetScreen
            val intent = Intent(this, BookCategory::class.java)
            startActivity(intent)
            finish()
        } else {
            // No user is logged in, stay on the login screen or handle accordingly
        }

    }
}

