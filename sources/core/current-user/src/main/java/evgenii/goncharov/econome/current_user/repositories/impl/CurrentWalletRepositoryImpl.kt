package evgenii.goncharov.econome.current_user.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import javax.inject.Inject

internal class CurrentWalletRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore
) : CurrentWalletRepository {

    private var currentWalletId: Long? = null

    override fun setCurrentWalletId(walletId: Long) {
        this.currentWalletId = walletId
    }

    override fun getCurrentWalletId(): Long? {
        return currentWalletId
    }
}