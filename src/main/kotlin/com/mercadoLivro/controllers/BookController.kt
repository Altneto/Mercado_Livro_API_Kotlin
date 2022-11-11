package com.mercadoLivro.controllers

import com.mercadoLivro.dao.BookDAO
import com.mercadoLivro.dto.BookDTO
import com.mercadoLivro.dto.BookUpdateDTO
import com.mercadoLivro.models.Book
import com.mercadoLivro.services.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController (
    val bookService: BookService
    ) {

    @GetMapping
    fun findAll(@RequestParam name: String?): List<Book> {
        return bookService.findAll(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody book: BookDTO): BookDAO {
        return bookService.save(book)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookDAO {
        return bookService.findById(id)
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@RequestBody dto: BookUpdateDTO) {
        return bookService.update(dto)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        return bookService.delete(id)
    }
}