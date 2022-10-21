package com.mercadoLivro.controllers

import com.mercadoLivro.dao.CustomerDAO
import com.mercadoLivro.dto.CustomerDTO
import com.mercadoLivro.models.Customer
import com.mercadoLivro.services.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController (
    val customerService: CustomerService
    ) {

    @GetMapping
    fun findAll(): List<Customer> {
        return customerService.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody customer: CustomerDTO): CustomerDAO {
        return customerService.save(customer)
    }
}