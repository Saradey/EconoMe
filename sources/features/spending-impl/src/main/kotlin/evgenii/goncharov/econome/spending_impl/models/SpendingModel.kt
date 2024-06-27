package evgenii.goncharov.econome.spending_impl.models

internal data class SpendingModel(
    val id: Long,
    val amount: Float,
    val comment: String,
    val categoriesId: List<Long>
)