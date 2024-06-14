package evgenii.goncharov.econome.wallet_impl.models

import androidx.annotation.DrawableRes
import evgenii.goncharov.econome.common.consts.CurrencyCode

internal data class CurrencyModel(
    val code: CurrencyCode,
    val title: String,
    val switch: Boolean,
    @DrawableRes val icon: Int
)