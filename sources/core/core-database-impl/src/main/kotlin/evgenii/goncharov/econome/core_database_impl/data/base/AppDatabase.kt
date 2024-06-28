package evgenii.goncharov.econome.core_database_impl.data.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import evgenii.goncharov.econome.core_database_impl.common.DATABASE_VERSION
import evgenii.goncharov.econome.core_database_impl.converters.DateConverter
import evgenii.goncharov.econome.core_database_impl.converters.LongsListConverter
import evgenii.goncharov.econome.core_database_impl.dao.CurrentWalletDao
import evgenii.goncharov.econome.core_database_impl.dao.SpendingDao
import evgenii.goncharov.econome.core_database_impl.dao.UserDao
import evgenii.goncharov.econome.core_database_impl.dao.WalletDao
import evgenii.goncharov.econome.core_database_impl.entities.CurrentWalletEntity
import evgenii.goncharov.econome.core_database_impl.entities.SpendingEntity
import evgenii.goncharov.econome.core_database_impl.entities.UserEntity
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity

@Database(
    entities = [
        UserEntity::class,
        WalletEntity::class,
        CurrentWalletEntity::class,
        SpendingEntity::class
    ],
    version = DATABASE_VERSION
)
@TypeConverters(
    value = [
        DateConverter::class,
        LongsListConverter::class
    ]
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun getWalletDao(): WalletDao

    abstract fun getCurrentWalletDao(): CurrentWalletDao

    abstract fun getSpendingDao(): SpendingDao
}