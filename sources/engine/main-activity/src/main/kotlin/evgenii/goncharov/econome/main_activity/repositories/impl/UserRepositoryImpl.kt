package evgenii.goncharov.econome.main_activity.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.main_activity.repositories.UserRepository
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore,
) : UserRepository {

    override suspend fun getAllUsers(): List<UserDto> {
        return userDataStore.getAllUsers()
    }

    override suspend fun getCurrentUser(): UserDto {
        return  userDataStore.getAllUsers().last()
    }
}