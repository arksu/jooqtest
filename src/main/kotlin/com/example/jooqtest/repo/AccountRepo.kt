package com.example.jooqtest.repo

import com.example.jooq.Tables.ACCOUNT
import com.example.jooq.tables.pojos.Account
import com.example.jooqtest.controller.dto.AccountRequestDTO
import org.jooq.DSLContext
import org.springframework.stereotype.Repository

@Repository
class AccountRepo(
    val dslContext: DSLContext
) {
    fun findByAccount(account: String): Account? {
        return null
    }

    fun addAccount(request: AccountRequestDTO): Account {
        return dslContext.insertInto(ACCOUNT)
            .set(ACCOUNT.NAME, request.name)
            .set(ACCOUNT.CITY, request.city)
            .set(ACCOUNT.SEX, request.sex)
            .returning()
            .fetchOneInto(Account::class.java)!!
    }
}