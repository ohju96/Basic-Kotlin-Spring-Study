package com.example.mvccrud.service.impl

import com.example.mvccrud.dto.UserDTO
import com.example.mvccrud.repository.UserRepository
import com.example.mvccrud.request.UserCreateRequest
import com.example.mvccrud.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
): UserService {

    override fun createUsers(userDTO: UserDTO) {
        val userEntity = UserCreateRequest(userDTO.name, userDTO.age)
        userRepository.save(userEntity)
    }

    override fun getUsers(userDTO: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun editUsers(userDTO: UserDTO) {
        TODO("Not yet implemented")
    }

    override fun deleteUsers(userDTO: UserDTO) {
        TODO("Not yet implemented")
    }
}