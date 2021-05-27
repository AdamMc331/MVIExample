package com.adammcneilly.mviexample

class ProdLoginService : LoginRepository {

    override fun login(email: String, password: String): Boolean {
        return true
    }
}
