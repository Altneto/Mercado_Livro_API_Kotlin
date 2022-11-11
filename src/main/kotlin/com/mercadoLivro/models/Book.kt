package com.mercadoLivro.models

import com.mercadoLivro.utils.enums.Status
import java.math.BigDecimal
import javax.persistence.*

@Entity()
data class Book (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @Column
    @Enumerated(EnumType.STRING)
    var status: Status,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: Customer?
)