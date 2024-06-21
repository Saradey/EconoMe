package evgenii.goncharov.econome.main_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class MainRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore,
    private val walletDataStore: WalletDataStore
) : MainRepository {

    override suspend fun getUserById(currentUserId: String): UserDto = withContext(Dispatchers.IO) {

    }

    override suspend fun getWalletById(currentWalletId: Long): WalletDto =
        withContext(Dispatchers.IO) {

        }
}