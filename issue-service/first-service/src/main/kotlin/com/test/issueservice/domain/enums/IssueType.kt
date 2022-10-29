package com.test.issueservice.domain.enums

enum class IssueType {

    BUG, TASK;

    companion object {
        // operator을 사용하면 생성자를 사용하는 것 처럼 사용할 수 있게 된다.
        operator fun invoke(type:String) = valueOf(type.uppercase())
    }
}