package core_data

import core_data.model.Account
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(
    private val accountDataSource: AccountDataSource
) : AccountRepository {

    override suspend fun insert(account: Account) {
        val currentAccountList = accountDataSource.get()
        val newAccountList = currentAccountList.
    }

    override suspend fun update(account: Account) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAll(): Flow<List<Account>> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Flow<Account> {
        TODO("Not yet implemented")
    }

}

interface AccountRepository {
    suspend fun insert(account: Account)

    suspend fun update(account: Account)

    suspend fun delete(id: Long)

    fun getAll(): Flow<List<Account>>

    fun getById(id: Long): Flow<Account>
}