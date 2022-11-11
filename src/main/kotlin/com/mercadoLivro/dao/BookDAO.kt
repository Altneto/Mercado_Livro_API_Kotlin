package com.mercadoLivro.dao

import com.mercadoLivro.models.Customer
import com.mercadoLivro.utils.enums.Status
import java.math.BigDecimal

data class BookDAO (
    var id: Int?,

    var name: String,

    var price: BigDecimal,

    var status: Status,

    var customer: Customer?
)