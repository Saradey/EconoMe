package evgenii.goncharov.econome.core_database_api.di

import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore

public interface CoreDatabaseApi {

    public fun provideUserDataStore() : UserDataStore

    public fun provideWalletDataStore(): WalletDataStore

    public fun provideCurrentWalletDataStore(): CurrentWalletDataStore
}