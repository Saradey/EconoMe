package evgenii.goncharov.econome.wallet_impl.models.mappers

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.currency.models.CurrencyDto
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import javax.inject.Inject

internal class CurrencyDtoToCurrencyModelMapper @Inject constructor() {

    fun map(currencyDto: CurrencyDto) : CurrencyModel {
        CurrencyModel(
            code = CurrencyCode.fromString(currencyDto.code),
            title =
        )
    }
}