package com.example.android.dagger.splashscreen

import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserManager
import javax.inject.Inject

/**
 * SplashViewModel is the ViewModel that [SplashActivity] uses to handle complex logic.
 */
class SplashViewModel @Inject constructor(
    private val userManager: UserManager
) {

    fun getDestinationActivity(): Class<out AppCompatActivity> {
        return if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                RegistrationActivity::class.java
            } else {
                LoginActivity::class.java
            }
        } else {
            MainActivity::class.java
        }
    }

}