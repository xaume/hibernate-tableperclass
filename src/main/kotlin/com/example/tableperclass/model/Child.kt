package com.example.tableperclass.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "CHILD")
class Child(
    override var id: UUID? = null,
    override var name: String,
    override var status: String,

    @Column(name= "AMOUNT")
    var amount: Int = 0

) : Parent(
    id = id,
    name = name,
    status = status
)