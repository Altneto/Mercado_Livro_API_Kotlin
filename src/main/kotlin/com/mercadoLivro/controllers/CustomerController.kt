package com.mercadoLivro.controllers

import com.mercadoLivro.VOS.CustomerVO
import com.mercadoLivro.models.Customer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController {

    @GetMapping
    fun getCustomer(): Customer {
        return Customer("1", "Gustavo", "email@email.com")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody customer: CustomerVO): CustomerVO {
        return customer
    }
}