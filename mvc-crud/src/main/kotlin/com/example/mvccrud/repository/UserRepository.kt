package com.example.mvccrud.repository

import com.example.mvccrud.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long>{
}