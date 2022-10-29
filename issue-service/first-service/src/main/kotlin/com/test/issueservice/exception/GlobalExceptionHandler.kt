package com.test.issueservice.exception

import com.auth0.jwt.exceptions.TokenExpiredException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice // or ControllerAdvice를 사용해 전체 컨트롤러에서 발생하는 모든 예외를 감지한다.
class GlobalExceptionHandler {

    // Kotlin 로깅을 활용한다.
    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ServerException::class)
    fun handleServerException(ex: ServerException) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = ex.code, message = ex.message)
    }

    @ExceptionHandler(TokenExpiredException::class)
    fun handleTokenExpiredException(ex: TokenExpiredException) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = 401, message = "Token Expired Error")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception) : ErrorResponse {
        logger.error { ex.message }

        return ErrorResponse(code = 500, message = "Internal Server Error")
    }
}