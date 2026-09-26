package com.example.pam4_modul

import kotlinx.coroutines.delay
import kotlin.random.Random

class Repo {
    companion object {
        suspend fun getData(): Int {
            delay(2000) // Simulasi menunggu pengambilan data selama 2 detik
            return Random.nextInt(100, 1000)
        }
    }
}