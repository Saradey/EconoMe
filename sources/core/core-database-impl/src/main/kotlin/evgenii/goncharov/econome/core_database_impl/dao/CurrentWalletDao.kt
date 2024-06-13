package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import evgenii.goncharov.econome.core_database_impl.entities.CurrentWalletEntity

@Dao
internal interface CurrentWalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveWallet(entity: CurrentWalletEntity)
}