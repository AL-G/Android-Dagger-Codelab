package com.example.android.dagger.splashscreen

import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.main.MainViewModel
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.user.UserDataRepository
import com.example.android.dagger.user.UserManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when` as whenever

class SplashViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var viewModel: SplashViewModel

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        viewModel = SplashViewModel(userManager)
    }

    @Test
    fun `Return correct activity for registered and logged in user`() {
        whenever(userManager.isUserLoggedIn()).thenReturn(true)
        whenever(userManager.isUserRegistered()).thenReturn(true)
        assertEquals(MainActivity::class.java, viewModel.getDestinationActivity())
    }

    @Test
    fun `Return correct activity for registered and logged out user`() {
        whenever(userManager.isUserLoggedIn()).thenReturn(false)
        whenever(userManager.isUserRegistered()).thenReturn(true)
        assertEquals(LoginActivity::class.java, viewModel.getDestinationActivity())
    }

    @Test
    fun `Return correct activity for unregistered`() {
        whenever(userManager.isUserLoggedIn()).thenReturn(false)
        whenever(userManager.isUserRegistered()).thenReturn(false)
        assertEquals(RegistrationActivity::class.java, viewModel.getDestinationActivity())
    }

}