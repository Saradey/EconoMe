package evgenii.goncharov.econome.spending_impl.models

internal data class SpendingInfoModel(
    val amount: String,
    val comment: String,
    val categories: List<String>,
    val spendingTime: String
)