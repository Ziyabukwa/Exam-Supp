package com.example.examsupp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window. setFlags( // (IIE, 2024)
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({// (IIE, 2024)
            val intent = Intent (this, ScreenMain::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3000 is the delayed time in milliseconds
    }

}



