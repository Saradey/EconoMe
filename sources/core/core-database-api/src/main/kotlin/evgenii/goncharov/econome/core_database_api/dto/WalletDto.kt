package evgenii.goncharov.econome.core_database_api.dto

public data class WalletDto(
    val id: Long,
    val walletName: String,
    val code: String,
    val sequenceNumber: Int
)