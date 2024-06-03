package evgenii.goncharov.econome.wallet_impl.models

import androidx.annotation.DrawableRes

internal data class CurrencyModel(
    val iso2Code: String,
    val title: String,
    val switch: Boolean,
    @DrawableRes val icon: Int
)