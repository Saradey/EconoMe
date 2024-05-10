package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Query
import evgenii.goncharov.econome.core_database_impl.common.USERS_TABLE
import evgenii.goncharov.econome.core_database_impl.entities.UserEntity

@Dao
internal interface UserDao {

    @Query("SELECT * FROM $USERS_TABLE")
    fun getAllUsers(): List<UserEntity>
}