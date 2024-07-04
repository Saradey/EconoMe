package evgenii.goncharov.econome.main_impl.models.mappers

import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.main_impl.models.SpendingModel
import javax.inject.Inject

internal class MapperSpendingDtoToSpendingModel @Inject constructor() {

    fun map(spendings: List<SpendingDto>): List<SpendingModel> {
        return spendings.map { dto ->
            SpendingModel(
                amount = dto.amount.toDouble()
            )
        }
    }
}