package com.example.mvccrud.entity

import org.apache.catalina.User
import javax.persistence.*

@Entity
@Table
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int? = null,

    @Column(nullable = false)
    private val name: String,

    @Column(nullable = false)
    private val age: Int,
)