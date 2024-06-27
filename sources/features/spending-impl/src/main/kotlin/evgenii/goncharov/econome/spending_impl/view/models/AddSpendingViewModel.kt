package evgenii.goncharov.econome.spending_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.spending_impl.models.AddSpendingUiState
import evgenii.goncharov.econome.spending_impl.models.mappers.MapperCategoryModelToSpendingCategory
import evgenii.goncharov.econome.spending_impl.use.cases.InputSpendingValidatorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class AddSpendingViewModel @Inject constructor(
    defaultCategoryInteractor: DefaultCategoryInteractor,
    mapper: MapperCategoryModelToSpendingCategory,
    private val inputSpendingValidatorUseCase: InputSpendingValidatorUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<AddSpendingUiState> =
        MutableStateFlow(
            AddSpendingUiState(
                spendingCategories = mapper.mapCategoryModelToSpendingCategory(
                    defaultCategoryInteractor.provideCategories()
                )
            )
        )
    val uiState: StateFlow<AddSpendingUiState> = _uiState

    fun inputSpending(spending: String) {
        val trimSpending = spending.trim()
        if (inputSpendingValidatorUseCase.invoke(trimSpending) || trimSpending.isEmpty()) {
            _uiState.value = _uiState.value.copy(
                inputSpending = trimSpending
            )
        }
    }

    fun inputComment(comment: String) {
        _uiState.value = _uiState.value.copy(
            inputComment = comment
        )
    }

    fun chooseSpendingCategory(spendingCategoryId: Long) {

    }
}