package evgenii.goncharov.econome.core_database_api.data.stores

import evgenii.goncharov.econome.core_database_api.dto.UserDto

public interface UserDataStore {

    public fun getAllUsers(): List<UserDto>
}