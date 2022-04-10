package com.example.distributedlock.controller

object OrderDto {
    object Request {
        data class Create(
            val id: String,
            val userId: Long,
        )
    }
}
