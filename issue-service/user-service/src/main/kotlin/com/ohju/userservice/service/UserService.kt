package com.ohju.userservice.service

import com.ohju.userservice.config.JWTProperties
import com.ohju.userservice.domain.entity.User
import com.ohju.userservice.domain.repository.UserRepository
import com.ohju.userservice.exception.PasswordNotMatchedException
import com.ohju.userservice.exception.UserExistsException
import com.ohju.userservice.exception.UserNotFoundException
import com.ohju.userservice.model.SignInRequest
import com.ohju.userservice.model.SignInResponse
import com.ohju.userservice.model.SignUpRequest
import com.ohju.userservice.utils.BCryptUtils
import com.ohju.userservice.utils.JWTClaim
import com.ohju.userservice.utils.JWTUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {

    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

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

    suspend fun signIn(signInReqeust: SignInRequest): SignInResponse {
        return with( userRepository.findByEmail(signInReqeust.email) ?: throw UserNotFoundException()) {
            val verified = BCryptUtils.verify(signInReqeust.password, password)
            if (!verified) {
                throw PasswordNotMatchedException()
            }

            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username
            )

            val token = JWTUtils.createToken(jwtClaim, jwtProperties)

            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)
            SignInResponse(
                email = email,
                username = username,
                token = token
            )

        }
    }

    suspend fun logout(token: String) {
        cacheManager.awaitEvict(token)
    }
}