package evgenii.goncharov.econome.core_database_impl.entities.relationships

import androidx.room.Embedded
import androidx.room.Relation
import evgenii.goncharov.econome.core_database_impl.entities.UserEntity
import evgenii.goncharov.econome.core_database_impl.entities.WalletEntity

internal data class UserWithWallets(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "uuid",
        entityColumn = "user_id"
    )
    val wallets: List<WalletEntity>
)