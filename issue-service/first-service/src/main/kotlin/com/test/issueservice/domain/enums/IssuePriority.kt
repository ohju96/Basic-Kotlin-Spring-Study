package com.test.issueservice.domain.enums

enum class IssuePriority {

    LOW, MEDIUM, HIGH;

    companion object {
        // 정적 함수 대신 사용하는데
        // invoke가 많이 사용되긴 하지만 추천하지 않는 사람도 더러 있다.
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }
}
