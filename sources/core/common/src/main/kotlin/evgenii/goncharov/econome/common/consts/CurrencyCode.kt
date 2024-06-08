package evgenii.goncharov.econome.common.consts

public enum class CurrencyCode(public val code: String) {
    RUB("RUB"),
    EUR("EUR"),
    USD("USD");

    public companion object {
        public fun fromString(code: String): CurrencyCode? {
            return entries.find { it.code == code }
        }
    }
}