package evgenii.goncharov.econome.wallet_impl.models.mappers

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.currency.models.CurrencyDto
import evgenii.goncharov.econome.wallet_impl.R
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import javax.inject.Inject

internal class CurrencyDtoToCurrencyModelMapper @Inject constructor(
    private val resourceManager: ResourceManager,
) {

    fun map(currencyDto: CurrencyDto): CurrencyModel {
        val currencyCode = CurrencyCode.fromString(currencyDto.code)
            ?: throw IllegalArgumentException(CURRENCY_ERROR_MAP_MESSAGE)
        return CurrencyModel(
            code = currencyCode,
            title = getTitle(currencyCode),
            switch = false,
            icon = -1
        )
    }

    private fun getTitle(code: CurrencyCode): String {
        return when (code) {
            CurrencyCode.RUB -> resourceManager.getString(R.string.currency_ru_title)
            CurrencyCode.EUR -> resourceManager.getString(R.string.currency_eur_title)
            CurrencyCode.USD -> resourceManager.getString(R.string.currency_dollar_title)
        }
    }

    private companion object {
        const val CURRENCY_ERROR_MAP_MESSAGE = "This currency doesn't exist"
    }
}