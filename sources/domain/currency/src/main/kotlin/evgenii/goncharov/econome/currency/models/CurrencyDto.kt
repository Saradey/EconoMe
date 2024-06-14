package evgenii.goncharov.econome.currency.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CurrencyDto(
    @SerialName("code") val code: String,
    @SerialName("symbol") val symbol: String
)
