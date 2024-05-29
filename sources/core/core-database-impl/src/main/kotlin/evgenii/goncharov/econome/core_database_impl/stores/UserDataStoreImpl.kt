package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.core_database_impl.dao.UserDao
import evgenii.goncharov.econome.core_database_impl.mappers.UserMapper
import javax.inject.Inject

internal class UserDataStoreImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : UserDataStore {

    override suspend fun getAllUsers(): List<UserDto> {
        return userMapper.mapUsersEntityToUsersDto(userDao.getAllUsers())
    }

    override suspend fun saveNewUser(user: UserDto) {
        userDao.saveUser(
            userMapper.mapUserDtoToUserEntity(user)
        )
    }
}