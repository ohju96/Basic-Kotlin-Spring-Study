package com.example.mvccrud.controller

import com.example.mvccrud.dto.UserDTO
import com.example.mvccrud.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/create")
    fun createUser(@RequestBody userDTO: UserDTO) {
        userService.createUsers(userDTO)
    }
}