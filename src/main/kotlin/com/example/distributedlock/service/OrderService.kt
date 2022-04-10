package com.example.distributedlock.service

import com.example.distributedlock.repository.mongo.OrderRepository
import com.example.distributedlock.repository.redis.OrderLockRedisRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderLockRedisRepository: OrderLockRedisRepository,
    private val orderRepository: OrderRepository
) {

    fun order(
        id: String,
        userId: Long,
    ) {
        val availableLock = orderLockRedisRepository.lock(id)

        if (!availableLock) {
            throw IllegalArgumentException("$id already in use")
        }

        val alreadyBuy = orderRepository.existsBuyHistory(userId, id)

        if (alreadyBuy) {
            throw IllegalArgumentException("$userId is already buy")
        }

        orderRepository.order(id, userId)

        orderLockRedisRepository.unlock(id)
    }
}
