package evgenii.goncharov.econome.main_activity.repositories

import evgenii.goncharov.econome.core_database_api.dto.WalletDto

internal interface WalletRepository {

    suspend fun getAllWallets(): List<WalletDto>

    suspend fun getCurrentWalletId(): Long
}