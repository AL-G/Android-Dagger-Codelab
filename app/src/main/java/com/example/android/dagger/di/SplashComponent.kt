package com.example.android.dagger.di

import com.example.android.dagger.splashscreen.SplashActivity
import dagger.Subcomponent

// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
// Definition of a Dagger subcomponent
@Subcomponent
interface SplashComponent {

    // Factory to create instances of Splash Component
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: SplashActivity)
}