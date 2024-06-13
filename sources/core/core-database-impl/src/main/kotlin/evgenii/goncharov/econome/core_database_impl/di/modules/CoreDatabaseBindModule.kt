package evgenii.goncharov.econome.core_database_impl.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_impl.stores.CurrentWalletDataStoreImpl
import evgenii.goncharov.econome.core_database_impl.stores.UserDataStoreImpl
import evgenii.goncharov.econome.core_database_impl.stores.WalletDataStoreImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CoreDatabaseBindModule {

    @CoreScope
    @Binds
    fun bindUserDataStore(store: UserDataStoreImpl): UserDataStore

    @CoreScope
    @Binds
    fun bindWalletDataStore(store: WalletDataStoreImpl): WalletDataStore

    @CoreScope
    @Binds
    fun bindCurrentWalletDataStoreImpl(store: CurrentWalletDataStoreImpl): CurrentWalletDataStore
}