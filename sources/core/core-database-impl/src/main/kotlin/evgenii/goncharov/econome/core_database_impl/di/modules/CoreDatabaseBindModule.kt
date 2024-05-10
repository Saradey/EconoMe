package evgenii.goncharov.econome.core_database_impl.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_impl.stores.UserDataStoreImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CoreDatabaseBindModule {

    @CoreScope
    @Binds
    fun bindUserDataStore(store: UserDataStoreImpl): UserDataStore
}