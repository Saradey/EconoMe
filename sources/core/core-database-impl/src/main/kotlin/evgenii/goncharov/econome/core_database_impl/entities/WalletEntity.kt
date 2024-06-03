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
        childColumns = ["id"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class WalletEntity(
    @ColumnInfo("id") @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo("wallet_name") val walletName: String,
    @ColumnInfo("wallet_code") val code: String
)
