package com.example.english_learning_app

import android.content.Context

class UserManager(context: Context) {
    companion object {
        private const val PREFS_NAME = "UserPrefs"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }

    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun registerUser(username: String, password: String) {
        sharedPreferences.edit().apply {
            putString(KEY_USERNAME, username)
            putString(KEY_PASSWORD, password)
            apply()
        }
    }

    fun getRegisteredUsername(): String {
        return sharedPreferences.getString(KEY_USERNAME, "") ?: ""
    }

    fun getRegisteredPassword(): String {
        return sharedPreferences.getString(KEY_PASSWORD, "") ?: ""
    }

    fun checkCredentials(username: String, password: String): Boolean {
        val registeredUsername = getRegisteredUsername()
        val registeredPassword = getRegisteredPassword()
        return username == registeredUsername && password == registeredPassword
    }
}