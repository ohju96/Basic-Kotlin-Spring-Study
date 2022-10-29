package com.test.issueservice.exception

// 예외 처리를 위한 클래스
data class ErrorResponse(
    val code: Int, // 에러 코드
    val message: String, // 에러 발생 시 특정 메시지
)
