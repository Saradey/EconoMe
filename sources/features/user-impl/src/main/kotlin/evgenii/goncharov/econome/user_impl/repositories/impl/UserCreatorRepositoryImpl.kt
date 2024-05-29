package evgenii.goncharov.econome.user_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.user_impl.repositories.UserCreatorRepository
import javax.inject.Inject

internal class UserCreatorRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore
) : UserCreatorRepository {

    override suspend fun saveNewUser(userId: String, userInputName: String) {
        userDataStore.saveNewUser(
            UserDto(
                uuid = userId,
                userName = userInputName
            )
        )
    }
}