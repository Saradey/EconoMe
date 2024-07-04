package evgenii.goncharov.econome.common.consts

public enum class CurrencyCode(
    public val code: String,
    public val symbol: String
) {
    RUB(
        code = "RUB",
        symbol = "₽"
    ),
    EUR(
        code = "EUR",
        symbol = "€"
    ),
    USD(
        code = "USD",
        symbol = "$"
    );

    public companion object {
        public fun fromString(code: String): CurrencyCode? {
            return entries.find { it.code == code }
        }

        public fun toSymbolString(code: String): String {
            return entries.find { it.code == code }?.symbol ?: throw IllegalArgumentException(
                MESSAGE_ERROR_CURRENCY_SYMBOL
            )
        }

        private const val MESSAGE_ERROR_CURRENCY_SYMBOL = "Currency code not exist"
    }
}