package evgenii.goncharov.econome.core_database_impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import evgenii.goncharov.econome.core_database_impl.common.WALLET_TABLE
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity

@Dao
internal interface WalletDao {

    @Insert
    fun saveWallet(wallet: WalletEntity)

    @Query("SELECT * FROM $WALLET_TABLE")
    fun getWallets(): List<WalletEntity>

    @Query("SELECT * FROM $WALLET_TABLE ORDER BY sequence_number DESC LIMIT 1")
    fun getWalletWithMaxSequenceNumber(): WalletEntity?

    @Query("SELECT * FROM $WALLET_TABLE WHERE wallet_id = :walletId")
    fun getWalletById(walletId: Long): WalletEntity
}