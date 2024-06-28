package evgenii.goncharov.econome.spending_impl.models

import java.util.Date

internal data class SpendingModel(
    val id: Long,
    val amount: Float,
    val comment: String,
    val categoriesId: List<Long>,
    val createAt: Date,
)