package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.core_database_impl.dao.UserDao
import evgenii.goncharov.econome.core_database_impl.mappers.UserMappers
import javax.inject.Inject

internal class UserDataStoreImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMappers: UserMappers
) : UserDataStore {

    override fun getAllUsers(): List<UserDto> {
        TODO("Not yet implemented")
    }
}