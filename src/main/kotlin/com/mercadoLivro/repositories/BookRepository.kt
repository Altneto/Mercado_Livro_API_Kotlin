package com.mercadoLivro.repositories

import com.mercadoLivro.models.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Int> {

    fun findByName(name: String): List<Book>
}