package evgenii.goncharov.econome.core_database_impl.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

internal data class SpendingEntity(
    @ColumnInfo("spending_id") @PrimaryKey val spendingId: Long,
)
