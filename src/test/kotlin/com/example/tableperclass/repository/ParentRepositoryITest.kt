package com.example.tableperclass.repository

import com.example.tableperclass.model.Child
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.util.*

@DataJpaTest
class ParentRepositoryITest {


    @Autowired
    private lateinit var repository: ParentRepository

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @BeforeEach
    fun cleanUp() {
        entityManager.clear()
    }

    @Test
    fun `should find all parents with ACTIVE status`() {
        // GIVEN
        repository.save(
            Child(
                id = UUID.randomUUID(),
                name = "Child 1",
                status = "ACTIVE",
                amount = 10
            )
        )
        repository.save(
            Child(
                id = UUID.randomUUID(),
                name = "Child 2",
                status = "INACTIVE",
                amount = 20
            )
        )

        // WHEN
        val result = repository.findAllExisting()

        // THEN
        assertThat(result).hasSize(1)
    }

}