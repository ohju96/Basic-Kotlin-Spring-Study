package com.example.mvccrud.service

import com.example.mvccrud.dto.UserDTO

interface UserService {

    // 생성
    fun createUsers(userDTO: UserDTO)

    // 조회
    fun getUsers(userDTO: UserDTO): UserDTO

    // 수정
    fun editUsers(userDTO: UserDTO)

    // 삭제
    fun deleteUsers(userDTO: UserDTO)
}