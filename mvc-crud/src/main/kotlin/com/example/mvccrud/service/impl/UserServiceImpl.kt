package com.example.mvccrud.service.impl

import com.example.mvccrud.dto.UserDTO
import com.example.mvccrud.mapper.UserMapper
import com.example.mvccrud.repository.UserRepository
import com.example.mvccrud.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper, // 정상 동작하나 밑 줄이 그어진다.

): UserService {

    override fun createUsers(userDTO: UserDTO) {
        userRepository.save(userMapper.toEntity(userDTO))
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