package core_data

import core_data.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf

class HardcodedAccountDataSource: AccountDataSource {

    private val accounts get() = mutableAccounts
    private var mutableAccounts = listOf(
        Account("testemail", "123"),
        Account("testemail2", "123123")
    )

    override fun get(): Flow<List<Account>> {
        return flowOf(accounts)
    }

    override fun save(accountList: List<Account>) {
        mutableAccounts = accountList
    }
}

interface AccountDataSource {
    fun get(): Flow<List<Account>>

    fun save (accountList: List<Account>)
}