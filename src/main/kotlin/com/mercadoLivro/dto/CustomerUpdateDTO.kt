package com.mercadoLivro.dto

data class CustomerUpdateDTO (
    var id: Int,

    var name: String? = null,

    var email: String? = null
)