package com.mercadoLivro.controllers

import com.mercadoLivro.models.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customer")
class CustomerController {

    @GetMapping
    fun getCustomer(): Customer {
        return Customer("1", "Gustavo", "email@email.com")
    }
}