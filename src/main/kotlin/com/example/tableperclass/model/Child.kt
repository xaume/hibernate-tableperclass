package com.example.tableperclass.model

import java.util.*
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "CHILD")
data class Child(
    override var id: UUID? = null,
    override var name: String,
    override var status: Status = Status.ACTIVE,

    @Column(name= "AMOUNT")
    var amount: Int = 0

) : Parent(
    id = id,
    name = name
) {
    override fun markInactive(): Parent {
        this.status = Status.INACTIVE
        // enabling this line makes it work,
        // setting the right status for the parent
        //super.status = Status.INACTIVE
        return this
    }
}