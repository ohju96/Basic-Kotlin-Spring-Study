package com.test.issueservice.exception

sealed class ServerException(
    val code: Int,
    override  val message: String,
) : RuntimeException()

data class NotFoundException(
    override val message: String,
) : ServerException(404, message) // http의 404가 아니라 커스텀한 404이다.

data class UnauthorizedException(
    override val message: String = "인증 정보가 잘못되었습니다.",
) : ServerException(401, message)
