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

    @Column(name = "AMOUNT")
    var amount: Int = 0

) : Parent(
    id = id,
    name = name,
    status = status
) {
    override fun markInactive(): Parent {
        this.status = Status.INACTIVE
        // FIXME: this line makes the persist work, setting the right status when persisting the entity
        // super.status = Status.INACTIVE
        return this
    }
}