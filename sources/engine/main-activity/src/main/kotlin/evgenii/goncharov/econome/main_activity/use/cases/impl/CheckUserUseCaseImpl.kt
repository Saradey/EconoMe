package evgenii.goncharov.econome.main_activity.use.cases.impl

import evgenii.goncharov.econome.main_activity.models.CheckUserModel
import evgenii.goncharov.econome.main_activity.repositories.MainActivityRepository
import evgenii.goncharov.econome.main_activity.use.cases.CheckUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class CheckUserUseCaseImpl @Inject constructor(
    private val mainActivityRepository: MainActivityRepository
) : CheckUserUseCase {

    override suspend fun invoke(): CheckUserModel = withContext(Dispatchers.IO) {
        val users = mainActivityRepository.getAllUsers()
        when {
            users.isEmpty() -> CheckUserModel.UserNotCreated
            users.size > INDEX_SIZE_NOT_EMPTY -> CheckUserModel.ManyUsersCreated
            else -> CheckUserModel.UserCreated
        }
    }

    private companion object {

        const val INDEX_SIZE_NOT_EMPTY = 1
    }
}