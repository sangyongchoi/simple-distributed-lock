package com.example.distributedlock.repository.mongo

import org.springframework.stereotype.Repository

@Repository
class OrderRepository {

    fun order(key: String, userId: Long) {
        println("order...")
        Thread.sleep(3000)
        println("order complete...")
    }
}
