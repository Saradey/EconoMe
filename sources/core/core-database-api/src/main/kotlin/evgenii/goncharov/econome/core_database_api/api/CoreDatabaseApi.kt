package evgenii.goncharov.econome.core_database_api.api

import evgenii.goncharov.econome.core_database_api.data.stores.CategorySpendingDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore

public interface CoreDatabaseApi {

    public fun provideUserDataStore() : UserDataStore

    public fun provideWalletDataStore(): WalletDataStore

    public fun provideCurrentWalletDataStore(): CurrentWalletDataStore

    public fun provideSpendingDataStore(): SpendingDataStore

    public fun provideCategorySpendingDataStore(): CategorySpendingDataStore
}