package evgenii.goncharov.econome.main_activity.repositories

import evgenii.goncharov.econome.core_database_api.dto.UserDto

internal interface MainActivityRepository {

    suspend fun getAllUsers(): List<UserDto>
}