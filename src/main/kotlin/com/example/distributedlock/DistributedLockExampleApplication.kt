package com.example.distributedlock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DistributedLockExampleApplication

fun main(args: Array<String>) {
    runApplication<DistributedLockExampleApplication>(*args)
}
