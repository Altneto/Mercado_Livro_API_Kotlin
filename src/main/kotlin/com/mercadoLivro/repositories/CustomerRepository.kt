package com.mercadoLivro.repositories

import com.mercadoLivro.models.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<Customer, Int> {
}