package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_impl.dao.CurrentWalletDao
import javax.inject.Inject

internal class CurrentWalletDataStoreImpl @Inject constructor(
    private val currentWalletDao: CurrentWalletDao
) : CurrentWalletDataStore {

}