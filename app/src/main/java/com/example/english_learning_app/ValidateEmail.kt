package com.example.english_learning_app

import android.util.Log

fun validateEmail(email: String): Boolean {
    val nameRegex = Regex("""^[a-zA-Z0-6]{1,30}$""")
    val domainRegex = Regex("""^[a-zA-Z0-9]+([\\.-][a-zA-Z0-9]+)*\.[a-zA-Z0-9]+([\\.-][a-zA-Z0-9]+)*$""")
    val topLevelDomainRegex = Regex("""^[a-zA-Z]{2,}$""")

    val emailParts = email.split("@")
    if (emailParts.size != 2) {
        Log.d("validateEmail", "emailParts.size != 2")
        return false
    }

    val name = emailParts[0]
    val domain = emailParts[1].split("\\.")[0]

    if (!nameRegex.matches(name)) {
        Log.d("validateEmail", "!nameRegex.matches(name)")
        return false
    }

    if (!domainRegex.matches(domain)) {
        Log.d("validateEmail", "!domainRegex.matches(domain)")
        return false
    }

    return true
}