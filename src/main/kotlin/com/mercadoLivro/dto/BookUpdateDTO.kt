package com.mercadoLivro.dto

import com.mercadoLivro.utils.enums.Status
import java.math.BigDecimal

data class BookUpdateDTO (
    var id: Int,

    var name: String? = null,

    var price: BigDecimal? = null,

    var status: Status? = null,

    var customerId: Int? = null
)