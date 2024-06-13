package evgenii.goncharov.econome.core_database_impl.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import evgenii.goncharov.econome.core_database_impl.common.CURRENT_WALLET_TABLE

@Entity(
    tableName = CURRENT_WALLET_TABLE,
    foreignKeys = [ForeignKey(
        entity = WalletEntity::class,
        parentColumns = ["wallet_id"],
        childColumns = ["current_wallet_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class CurrentWalletEntity(
    @ColumnInfo("id") @PrimaryKey val id: Int = 1,
    @ColumnInfo("current_wallet_id") val currentWalletId: Long
)