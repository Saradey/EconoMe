package evgenii.goncharov.econome.main_impl.models

internal data class SpendingItemModel(
    val idSpending: Long,
    val number: String,
    val amount: String,
    val comment: String,
    val spendingCategoryTitle: List<String>,
    val spendingTime: String
)