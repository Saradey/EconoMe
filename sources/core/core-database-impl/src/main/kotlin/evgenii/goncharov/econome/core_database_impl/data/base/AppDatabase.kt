package evgenii.goncharov.econome.core_database_impl.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import evgenii.goncharov.econome.core_database_impl.common.DATABASE_VERSION
import evgenii.goncharov.econome.core_database_impl.dao.UserDao
import evgenii.goncharov.econome.core_database_impl.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}