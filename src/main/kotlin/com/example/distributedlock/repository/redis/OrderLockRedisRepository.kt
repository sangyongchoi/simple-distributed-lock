package com.example.distributedlock.repository.redis

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderLockRedisRepository(
    private val orderRedisTemplate: RedisTemplate<String, Boolean>
) {

    fun lock(key: String): Boolean {
        return orderRedisTemplate
            .opsForValue()
            .setIfAbsent(key, true) ?: false
    }

    fun unlock(key: String): Boolean {
        return orderRedisTemplate.delete(key)
    }
}
