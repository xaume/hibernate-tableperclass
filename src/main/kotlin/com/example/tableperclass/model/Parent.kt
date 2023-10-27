package com.example.tableperclass.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.JdbcTypeCode
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Parent(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false)
    @JdbcTypeCode(java.sql.Types.VARCHAR)
//    @Type(type = "uuid-char")
    open var id: UUID? = null,

    @Column(name = "NAME")
    open var name: String,

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    open var status: Status
)