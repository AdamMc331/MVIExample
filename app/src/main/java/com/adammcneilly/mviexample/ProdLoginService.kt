package com.adammcneilly.mviexample

import kotlinx.coroutines.delay

class ProdLoginService : LoginRepository {

    override suspend fun login(email: String, password: String): Boolean {
        delay(2000)

        return true
    }
}
