package com.example.jooqtest.controller.dto

import com.example.jooq.enums.SexEnum
import java.util.*

data class AccountRequestDTO(
    val name: String,
    val city: String?,
    val sex: SexEnum
)

data class AccountResponseDTO(
    val id: UUID,
    val name: String,
    val city: String?,
    val sex: SexEnum
)