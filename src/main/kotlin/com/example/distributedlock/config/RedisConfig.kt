package com.example.distributedlock.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {

    @Bean
    fun orderRedisTemplate(
        redisConnectionFactory: RedisConnectionFactory,
    ): RedisTemplate<String, Boolean> {
        return RedisTemplate<String, Boolean>()
            .also { it.setConnectionFactory(redisConnectionFactory) }
    }
}
