package evgenii.goncharov.econome.main_impl.models.mappers

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.main_impl.models.SpendingItemModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

internal class MapperSpendingDtoToSpendingItemModel @Inject constructor(
    appLocale: Locale,
    private val defaultCategoryInteractor: DefaultCategoryInteractor
) {

    private val timeHourAndMinuteDateFormatter = SimpleDateFormat(TIME_FORMAT, appLocale)

    fun map(dto: List<SpendingDto>): List<SpendingItemModel> {
        return dto.mapIndexed { index, spendingDto ->
            SpendingItemModel(
                number = index.toString(),
                amount = spendingDto.amount.toString(),
                comment = spendingDto.comment,
                spendingCategoryTitle = ,
                spendingTime = timeHourAndMinuteDateFormatter.format(spendingDto.createAt)
            )
        }
    }

    private companion object {

        const val TIME_FORMAT = "HH-mm"
    }
}