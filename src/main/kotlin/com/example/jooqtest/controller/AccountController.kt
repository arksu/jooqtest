package com.example.jooqtest.controller

import com.example.jooq.tables.pojos.Account
import com.example.jooqtest.controller.dto.AccountRequestDTO
import com.example.jooqtest.controller.dto.AccountResponseDTO
import com.example.jooqtest.service.AccountService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("account")
class AccountController(
    private val accountService: AccountService
) {
    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): AccountResponseDTO {
        return mapAccountToDTO(accountService.get(id))
    }

    @PostMapping
    fun add(@RequestBody request: AccountRequestDTO): AccountResponseDTO {
        return mapAccountToDTO(accountService.addAccount(request))
    }

    fun mapAccountToDTO(it: Account): AccountResponseDTO {
        return AccountResponseDTO(
            id = it.id,
            name = it.name,
            city = it.city,
            sex = it.sex
        )
    }
}