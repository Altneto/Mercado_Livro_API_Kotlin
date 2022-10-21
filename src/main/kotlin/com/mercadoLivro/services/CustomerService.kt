package com.mercadoLivro.services

import com.mercadoLivro.dto.CustomerDTO
import com.mercadoLivro.models.Customer
import com.mercadoLivro.repositories.CustomerRepository
import com.mercadoLivro.dao.CustomerDAO
import com.mercadoLivro.dto.CustomerUpdateDTO
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository
    ) {

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

    fun findAll(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findByName(name)
        }
        return customerRepository.findAll().toList()
    }

    fun findById(id: Int): CustomerDAO {
        var customer = customerRepository.findById(id)
        if (customer.isEmpty) {
            throw Exception()
        }
        return customerToDAO(customer.get())
    }

    fun update(dto: CustomerUpdateDTO){
        var customer = customerRepository.findById(dto.id)
        if (customer.isEmpty) {
            throw Exception()
        }
        customer.get().name = dto.name!!
        customer.get().email = dto.email!!

        customerRepository.save(customer.get())
    }

    fun delete(id: Int) {
        var customer = customerRepository.findById(id)
        if (customer.isEmpty) {
            throw Exception()
        }

        customerRepository.deleteById(id);
    }
}