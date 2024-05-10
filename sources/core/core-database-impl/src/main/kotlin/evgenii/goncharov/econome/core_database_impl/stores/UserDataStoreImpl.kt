package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import javax.inject.Inject

internal class UserDataStoreImpl @Inject constructor() : UserDataStore {

    override fun getAllUsers(): List<UserDto> {
        TODO("Not yet implemented")
    }
}