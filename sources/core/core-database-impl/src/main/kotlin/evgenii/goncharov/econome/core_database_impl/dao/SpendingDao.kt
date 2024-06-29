package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import evgenii.goncharov.econome.core_database_impl.common.SPENDING_TABLE
import evgenii.goncharov.econome.core_database_impl.entities.SpendingEntity

@Dao
internal interface SpendingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSpending(entity: SpendingEntity)

    @Query(
        "SELECT * FROM $SPENDING_TABLE WHERE date(create_at / 1000, 'unixepoch') = date(:date / 1000, 'unixepoch') AND wallet_id_foreign = :walletId"
    )
    fun getSpendingsByDate(date: Long, walletId: Long): List<SpendingEntity>
}