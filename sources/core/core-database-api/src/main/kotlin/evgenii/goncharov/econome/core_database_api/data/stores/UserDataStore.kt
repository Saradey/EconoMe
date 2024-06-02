package evgenii.goncharov.econome.core_database_api.data.stores

import androidx.annotation.WorkerThread
import evgenii.goncharov.econome.core_database_api.dto.UserDto

public interface UserDataStore {

    @WorkerThread
    public suspend fun getAllUsers(): List<UserDto>

    @WorkerThread
    public suspend fun saveNewUser(user: UserDto)
}