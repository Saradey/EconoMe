package evgenii.goncharov.econome.core_database_impl.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import evgenii.goncharov.econome.core_database_impl.common.USERS_TABLE

@Entity(tableName = USERS_TABLE)
internal data class UserEntity(
    @PrimaryKey val uuid: String
)