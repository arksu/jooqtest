package com.example.jooqtest.service

import com.example.jooq.tables.pojos.Account
import com.example.jooqtest.controller.dto.AccountRequestDTO
import com.example.jooqtest.error.NotFoundException
import com.example.jooqtest.repo.AccountRepo
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(
    private val accountRepo: AccountRepo
) {
    fun addAccount(request: AccountRequestDTO): Account {
        return accountRepo.addAccount(request)
    }

    fun get(id: UUID): Account {
        return accountRepo.findById(id) ?: throw NotFoundException("Account not found")
    }
}