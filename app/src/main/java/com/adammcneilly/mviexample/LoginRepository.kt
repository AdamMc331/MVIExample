package com.adammcneilly.mviexample

interface LoginRepository {
    fun login(email: String, password: String): Boolean
}
