package com.example.riderstore.utils

import java.security.MessageDigest

fun hashSHA256(input: String): String {
    val bytes = MessageDigest
        .getInstance("SHA-256")
        .digest(input.toByteArray())

    return bytes.joinToString("") { "%02x".format(it) }
}
