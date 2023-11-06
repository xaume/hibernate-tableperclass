package com.example.tableperclass.repository

import com.example.tableperclass.model.Child
import com.example.tableperclass.model.Status
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

        // WHEN
        val result = repository.findAllActive()

        // THEN
        assertThat(result).hasSize(1)
    }

    @Test
    fun `stored parent should have status set`() {
        // GIVEN
        repository.save(
            Child(
                id = UUID.randomUUID(),
                name = "Child 1",
                amount = 10
            )
        )

        // WHEN
        val result = repository.findAll()

        // THEN
        assertThat(result).isNotEmpty
        assertThat(result[0].status).isNotNull
        assertThat(result[0].status).isEqualTo(Status.ACTIVE)
    }

}