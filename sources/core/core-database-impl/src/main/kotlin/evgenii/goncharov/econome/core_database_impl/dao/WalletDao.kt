package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity

@Dao
internal interface WalletDao {

    @Insert
    fun saveWallet(wallet: WalletEntity)
}