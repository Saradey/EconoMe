package evgenii.goncharov.econome.core_database_api.dto

import java.util.Date

public data class SpendingDto(
    val id: Long,
    val amount: Float,
    val comment: String,
    val createAt: Date,
    val categoriesId: List<Long>
)
