package com.example.mvccrud.request

import com.example.mvccrud.dto.UserDTO
import com.example.mvccrud.entity.UserEntity
import org.aspectj.weaver.loadtime.Agent

data class UserCreateRequests(
    val name: String
)

fun UserCreateRequest(name: String, age: Int) = UserEntity(
    name = name,
    age = age
)