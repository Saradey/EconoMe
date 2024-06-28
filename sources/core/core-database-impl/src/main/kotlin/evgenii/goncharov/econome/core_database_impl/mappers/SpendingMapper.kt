package evgenii.goncharov.econome.core_database_impl.mappers

import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.core_database_impl.entities.SpendingEntity
import javax.inject.Inject

internal class SpendingMapper @Inject constructor() {

    fun mapSpendingDtoToSpendingEntity(dto: SpendingDto) : SpendingEntity {
        return SpendingEntity(
            spendingId = dto.id,
            walletId = dto.walletId,
            amount = dto.amount,
            comment = dto.comment,
            createAt = dto.createAt,
            categoriesId = dto.categoriesId
        )
    }
}