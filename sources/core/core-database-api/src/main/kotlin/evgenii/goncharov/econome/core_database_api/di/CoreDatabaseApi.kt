package evgenii.goncharov.econome.core_database_api.di

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore

public interface CoreDatabaseApi {

    public fun provideUserDataStore() : UserDataStore
}