package com.example.tableperclass.service

import com.example.tableperclass.model.Child
import com.example.tableperclass.repository.ParentRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChildService(
    private val repository: ParentRepository
) {

    @PostConstruct
    fun insertEntries() {
        repository.save(
            Child(
                id = UUID.randomUUID(),
                name = "Child 1",
                amount = 10
            )
        )
        repository.save(
            Child(
                id = UUID.randomUUID(),
                name = "Child 2",
                amount = 20
            ).markInactive()
        )
        repository.flush()

        val entries = repository.findAllActive()
        assert(entries.size == 1)
    }

}