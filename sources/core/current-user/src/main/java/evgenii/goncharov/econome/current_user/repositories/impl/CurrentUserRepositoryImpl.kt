package evgenii.goncharov.econome.current_user.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import javax.inject.Inject

internal class CurrentUserRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : CurrentUserRepository {

    private var userId: String? = null

    override fun setCurrentUserId(userId: String) {
        this.userId = userId
    }

    override fun getCurrentUserId(): String? {
        return userId
    }
}