package com.example.tableperclass.model

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Parent(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false)
    //@JdbcTypeCode(java.sql.Types.VARCHAR)
    @Type(type = "uuid-char")
    open var id: UUID? = null,

    @Column(name = "NAME")
    open var name: String,

    @Column(name = "STATUS")
    open var status: String
)