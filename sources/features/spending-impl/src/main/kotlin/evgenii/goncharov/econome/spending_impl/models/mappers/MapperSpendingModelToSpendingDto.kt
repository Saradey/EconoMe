package evgenii.goncharov.econome.spending_impl.models.mappers

import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.spending_impl.models.SpendingModel
import javax.inject.Inject

internal class MapperSpendingModelToSpendingDto @Inject constructor() {

    fun mapSpendingModelToSpendingDto(model : SpendingModel) : SpendingDto {
        return SpendingDto(
            id = model.id,
            walletId = model.walletId,
            amount = model.amount,
            comment = model.comment,
            createAt = model.createAt,
            categoriesId = model.categoriesId
        )
    }
}