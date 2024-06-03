package evgenii.goncharov.econome.wallet_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import javax.inject.Inject

internal class WalletCreatorRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore
) : WalletCreatorRepository {


}