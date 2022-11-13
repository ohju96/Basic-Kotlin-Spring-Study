package com.example.mvccrud.mapper

import com.example.mvccrud.dto.UserDTO
import com.example.mvccrud.entity.UserEntity
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "string", uses = [], unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper: EntityMapper<UserDTO, UserEntity> {
}