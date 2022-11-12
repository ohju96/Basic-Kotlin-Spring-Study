package com.ohju.userservice.service

import com.ohju.userservice.domain.entity.User
import com.ohju.userservice.domain.repository.UserRepository
import com.ohju.userservice.exception.UserExistsException
import com.ohju.userservice.model.SignUpRequest
import com.ohju.userservice.utils.BCryptUtils
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    suspend fun signUp(singUpRequest: SignUpRequest) {
        with(singUpRequest) {
            userRepository.findByEmail(email)?.let { //이메일 주소로 가입한 회원이 있으면 예외 발생
                throw UserExistsException()
            }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )
            userRepository.save(user)
        }
    }
}