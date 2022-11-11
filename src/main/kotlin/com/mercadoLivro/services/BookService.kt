package com.mercadoLivro.services

import com.mercadoLivro.dao.BookDAO
import com.mercadoLivro.dto.BookDTO
import com.mercadoLivro.dto.BookUpdateDTO
import com.mercadoLivro.models.Book
import com.mercadoLivro.repositories.BookRepository
import com.mercadoLivro.repositories.CustomerRepository
import com.mercadoLivro.utils.enums.Status
import org.springframework.stereotype.Service

@Service
class BookService (
    val bookRepository: BookRepository,
    val customerRepository: CustomerRepository
    ) {

    fun save(book: BookDTO): BookDAO {
        var c = bookRepository.save(dtoToBook(book))
        return BookToDAO(c)
    }

    fun dtoToBook(dto: BookDTO): Book {
        val customer = customerRepository.findById(dto.customerId!!).get()
        return Book(name = dto.name, price = dto.price, status = Status.ATIVO, customer = customer)
    }

    fun BookToDAO(book: Book): BookDAO {
        return BookDAO(book.id, book.name, book.price, book.status, book.customer)
    }

    fun findAll(name: String?): List<Book> {
        name?.let {
            return bookRepository.findByName(name)
        }
        return bookRepository.findAll().toList()
    }

    fun findById(id: Int): BookDAO {
        var book = bookRepository.findById(id)
        if (book.isEmpty) {
            throw Exception()
        }
        return BookToDAO(book.get())
    }

    fun update(dto: BookUpdateDTO){
        var book = bookRepository.findById(dto.id)
        if (book.isEmpty) {
            throw Exception()
        }
        book.get().name = dto.name!!
        book.get().price = dto.price!!
        book.get().status = dto.status!!
        book.get().customer = customerRepository.findById(dto.customerId!!).get()

        bookRepository.save(book.get())
    }

    fun delete(id: Int) {
        var book = bookRepository.findById(id)
        if (book.isEmpty) {
            throw Exception()
        }

        bookRepository.deleteById(id);
    }
}