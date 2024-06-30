package evgenii.goncharov.econome.current_user.repositories.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import javax.inject.Inject

internal class CurrentWalletRepositoryImpl @Inject constructor() : CurrentWalletRepository {

    private var _currentWalletId: Long? = null

    override val currentWalletId: Long
        get() {
            return _currentWalletId ?: throw IllegalArgumentException(ERROR_MESSAGE_WALLET_ID)
        }

    override fun setCurrentWalletId(walletId: Long) {
        this._currentWalletId = walletId
    }

    private companion object {

        const val ERROR_MESSAGE_WALLET_ID = "current wallet id must be not null"
    }
}