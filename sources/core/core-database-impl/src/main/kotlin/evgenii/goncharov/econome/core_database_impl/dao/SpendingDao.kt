package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Query
import evgenii.goncharov.econome.core_database_impl.common.SPENDING_TABLE
import evgenii.goncharov.econome.core_database_impl.entities.SpendingEntity

@Dao
internal interface SpendingDao {

    @Query("SELECT * FROM $SPENDING_TABLE")
    fun getSpendings() : List<SpendingEntity>
}