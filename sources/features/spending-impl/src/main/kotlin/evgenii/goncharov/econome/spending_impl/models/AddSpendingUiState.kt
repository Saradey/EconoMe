package evgenii.goncharov.econome.spending_impl.models

internal data class AddSpendingUiState(
    val inputSpending: String = "",
    val inputComment: String = "",
    val spendingCategories: List<SpendingCategory>,
    val mainButtonEnabled: Boolean = false
)