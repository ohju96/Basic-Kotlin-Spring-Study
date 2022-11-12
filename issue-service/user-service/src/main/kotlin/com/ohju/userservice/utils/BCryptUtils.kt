package com.ohju.userservice.utils

import at.favre.lib.crypto.bcrypt.BCrypt
import io.netty.util.HashedWheelTimer

object BCryptUtils {

    fun hash(password: String) =
        BCrypt.withDefaults().hashToString(12, password.toCharArray())

    fun verify(password: String, hashedpassword: String) =
        BCrypt.verifyer().verify(password.toCharArray(), hashedpassword).verified
}