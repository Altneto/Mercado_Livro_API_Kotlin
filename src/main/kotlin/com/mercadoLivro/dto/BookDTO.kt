package com.mercadoLivro.dto

import java.math.BigDecimal

data class BookDTO (
    var name: String,

    var price: BigDecimal,

    var customerId: Int
)