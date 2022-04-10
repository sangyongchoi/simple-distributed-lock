package com.example.distributedlock.repository.mongo

import org.springframework.stereotype.Repository
import kotlin.random.Random

@Repository
class OrderRepository {

    fun existsBuyHistory(userId: Long, id: String): Boolean {
        val number = Random.Default.nextInt()

        return number % 2 == 0
    }

    fun order(key: String, userId: Long) {
        println("order...")
        Thread.sleep(3000)
        println("order complete...")
    }
}
