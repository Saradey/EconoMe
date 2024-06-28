package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import evgenii.goncharov.econome.core_database_impl.entities.SpendingEntity

@Dao
internal interface SpendingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSpending(entity: SpendingEntity)
}