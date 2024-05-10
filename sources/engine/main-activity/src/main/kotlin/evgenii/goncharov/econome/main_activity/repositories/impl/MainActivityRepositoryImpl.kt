package evgenii.goncharov.econome.main_activity.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.main_activity.repositories.MainActivityRepository
import javax.inject.Inject

internal class MainActivityRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : MainActivityRepository {
    
}