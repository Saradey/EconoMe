package evgenii.goncharov.econome.current_user.repositories.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import javax.inject.Inject

internal class CurrentUserRepositoryImpl @Inject constructor() : CurrentUserRepository {

    private var _currentUserIde: String? = null

    override val currentUserIde: String
        get() {
            return _currentUserIde ?: throw IllegalArgumentException(USER_ERROR_MESSAGE)
        }

    override fun setUserId(userId: String) {
        this._currentUserIde = userId
    }

    private companion object {

        const val USER_ERROR_MESSAGE = "Current user cannot be null"
    }
}