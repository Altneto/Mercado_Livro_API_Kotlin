package com.mercadoLivro.controllers

import com.mercadoLivro.dao.CustomerDAO
import com.mercadoLivro.dto.CustomerDTO
import com.mercadoLivro.dto.CustomerUpdateDTO
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): CustomerDAO {
        return customerService.findById(id)
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@RequestBody dto: CustomerUpdateDTO) {
        return customerService.update(dto)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        return customerService.delete(id)
    }
}