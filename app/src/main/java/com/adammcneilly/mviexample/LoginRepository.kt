package com.adammcneilly.mviexample

interface LoginRepository {
    suspend fun login(email: String, password: String): Boolean
}
