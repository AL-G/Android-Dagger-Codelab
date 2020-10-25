package com.example.android.dagger.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    // SplashViewModel is provided by Dagger
    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE) //will hide the title
        supportActionBar?.hide() // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ) //enable full screen
        // Creates an instance of Splash component by grabbing the factory from the app graph
        // and injects this activity to that Component
        (application as MyApplication).appComponent.splashComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val countdownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                startNextActivity()
            }
        }
        countdownTimer.start()
    }

    fun startNextActivity() {
        val destinationActivity = splashViewModel.getDestinationActivity()
        startActivity(Intent(this, destinationActivity))
        finish()
    }

}