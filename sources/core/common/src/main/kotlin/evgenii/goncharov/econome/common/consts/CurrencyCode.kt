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
    }
}