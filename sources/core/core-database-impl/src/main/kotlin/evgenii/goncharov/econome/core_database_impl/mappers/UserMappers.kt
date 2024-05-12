package evgenii.goncharov.econome.core_database_impl.mappers

import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.core_database_impl.entities.UserEntity
import javax.inject.Inject

internal class UserMappers @Inject constructor() {

    fun mapUsersEntityToUsersDto(users: List<UserEntity>): List<UserDto> {
        return users.map { entity ->
            UserDto(
                uuid = entity.uuid
            )
        }
    }
}