package evgenii.goncharov.econome.main_impl.repositories

import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.core_database_api.dto.WalletDto

internal interface MainRepository {

    suspend fun getUserById(currentUserId: String): UserDto

    suspend fun getWalletById(currentWalletId: Long): WalletDto
}