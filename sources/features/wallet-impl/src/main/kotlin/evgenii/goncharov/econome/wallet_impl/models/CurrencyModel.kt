package evgenii.goncharov.econome.wallet_impl.models

import androidx.annotation.DrawableRes

internal data class CurrencyModel(
    val code: String,
    val title: String,
    val switch: Boolean,
    @DrawableRes val icon: Int
)