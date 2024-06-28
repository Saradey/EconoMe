package evgenii.goncharov.econome.core_database_impl.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import evgenii.goncharov.econome.core_database_impl.common.SPENDING_TABLE
import java.util.Date

@Entity(
    tableName = SPENDING_TABLE,
    foreignKeys = [ForeignKey(
        entity = WalletEntity::class,
        parentColumns = ["wallet_id"],
        childColumns = ["wallet_id_foreign"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class SpendingEntity(
    @ColumnInfo("spending_id") @PrimaryKey val spendingId: Long,
    @ColumnInfo("wallet_id_foreign") val walletId: Long,
    @ColumnInfo("amount") val amount: Float,
    @ColumnInfo("comment") val comment: String,
    @ColumnInfo("create_at") val createAt: Date,
)
