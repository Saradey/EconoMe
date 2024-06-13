package evgenii.goncharov.econome.core_database_impl.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import evgenii.goncharov.econome.core_database_impl.common.WALLET_TABLE

@Entity(
    tableName = WALLET_TABLE,
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["uuid"],
        childColumns = ["user_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class WalletEntity(
    @ColumnInfo("wallet_id") @PrimaryKey val walletId: Long,
    @ColumnInfo("user_id") val userId: String,
    @ColumnInfo("wallet_name") val walletName: String,
    @ColumnInfo("wallet_code") val code: String,
    @ColumnInfo("sequence_number") val sequenceNumber: Int
)
