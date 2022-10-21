package com.mercadoLivro.services

import com.mercadoLivro.dto.CustomerDTO
import com.mercadoLivro.models.Customer
import com.mercadoLivro.repositories.CustomerRepository
import com.mercadoLivro.dao.CustomerDAO
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository
    ) {

    fun findAll(): List<Customer> {
        return customerRepository.findAll().toList()
    }

    fun save(customer: CustomerDTO): CustomerDAO {
        var c = customerRepository.save(dtoToCustomer(customer))
        return customerToDAO(c)
    }

    fun dtoToCustomer(dto: CustomerDTO): Customer {
        return Customer(name = dto.name, email = dto.email)
    }

    fun customerToDAO(customer: Customer): CustomerDAO {
        return CustomerDAO(customer.id, customer.name, customer.email)
    }
}