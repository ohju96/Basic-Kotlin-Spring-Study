package com.test.issueservice.domain

import com.test.issueservice.domain.enums.IssuePriority
import com.test.issueservice.domain.enums.IssueStatus
import com.test.issueservice.domain.enums.IssueType
import javax.persistence.*

@Entity
@Table
class Issue (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
     var userId: Long,

    @OneToMany(fetch = FetchType.EAGER)
    val comments : MutableList<Comment> = mutableListOf(),

    @Column
    var summary: String,

    @Column
    var description: String,

    @Column
    @Enumerated(EnumType.STRING)
    var type: IssueType,

    @Column
    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,

    @Column
    @Enumerated(EnumType.STRING)
    var status: IssueStatus,

    ) : BaseEntity()