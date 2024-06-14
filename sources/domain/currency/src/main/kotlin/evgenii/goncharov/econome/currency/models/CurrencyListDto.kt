package evgenii.goncharov.econome.currency.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CurrencyListDto(
    @SerialName("currencies") val currencies: List<CurrencyDto>,
)
