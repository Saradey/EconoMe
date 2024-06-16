package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import evgenii.goncharov.econome.core_database_impl.common.CURRENT_WALLET_TABLE
import evgenii.goncharov.econome.core_database_impl.entities.CurrentWalletEntity

@Dao
internal interface CurrentWalletDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveWallet(entity: CurrentWalletEntity)

    @Query("SELECT * FROM $CURRENT_WALLET_TABLE WHERE id = 1")
    fun getCurrentWallet(): CurrentWalletEntity?
}