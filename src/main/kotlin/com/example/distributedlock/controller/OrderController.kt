package com.example.distributedlock.controller

import com.example.distributedlock.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/order")
    fun order(
        @RequestBody request: OrderDto.Request.Create
    ): ResponseEntity<Any> {
        orderService.order(request.id, request.userId)

        return ResponseEntity.ok().build()
    }
}
