package com.example.tableperclass.repository

import com.example.tableperclass.model.Parent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ParentRepository: JpaRepository<Parent, UUID> {

    companion object {
        const val PARENT_IN_STATUS = "p.status IN (com.example.tableperclass.model.Status.ACTIVE)"
    }

    @Query(value = "SELECT p FROM Parent p WHERE $PARENT_IN_STATUS")
    fun findAllActive(): List<Parent>
}