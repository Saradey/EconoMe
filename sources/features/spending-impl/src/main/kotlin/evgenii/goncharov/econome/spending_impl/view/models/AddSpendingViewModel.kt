package evgenii.goncharov.econome.spending_impl.view.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.common.ui.SystemEvent
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher
import evgenii.goncharov.econome.spending_impl.interactors.AddSpendingInteractor
import evgenii.goncharov.econome.spending_impl.models.AddSpendingUiState
import evgenii.goncharov.econome.spending_impl.models.SpendingModel
import evgenii.goncharov.econome.spending_impl.models.mappers.MapperCategoryModelToSpendingCategory
import evgenii.goncharov.econome.spending_impl.use.cases.InputSpendingValidatorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject
import kotlin.random.Random

internal class AddSpendingViewModel @Inject constructor(
    defaultCategoryInteractor: DefaultCategoryInteractor,
    mapper: MapperCategoryModelToSpendingCategory,
    private val inputSpendingValidatorUseCase: InputSpendingValidatorUseCase,
    private val addSpendingInteractor: AddSpendingInteractor,
    private val currentWalletRepository: CurrentWalletRepository,
    private val mainDataRefresher: MainDataRefresher
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
    private val _systemEvent: MutableStateFlow<SystemEvent> = MutableStateFlow(
        SystemEvent.InitialState
    )
    val systemEvent: StateFlow<SystemEvent> = _systemEvent

    fun inputSpending(spending: String) {
        val trimSpending = spending.trim()
        if (inputSpendingValidatorUseCase.invoke(trimSpending)) {
            _uiState.value = _uiState.value.copy(
                inputSpending = trimSpending,
                mainButtonEnabled = addSpendingInteractor.validateMainButtonEnabled(
                    trimSpending,
                    _uiState.value.spendingCategories
                )
            )
        } else {
            _uiState.value = _uiState.value.copy(mainButtonEnabled = false)
        }
    }

    fun inputComment(comment: String) {
        _uiState.value = _uiState.value.copy(
            inputComment = comment
        )
    }

    fun chooseSpendingCategory(spendingCategoryId: Long) {
        addSpendingInteractor.chooseSpendingCategory(spendingCategoryId)
        val newCategories = addSpendingInteractor.calculateCategoriesState(
            _uiState.value.spendingCategories
        )
        _uiState.value = _uiState.value.copy(
            spendingCategories = newCategories,
            mainButtonEnabled = addSpendingInteractor.validateMainButtonEnabled(
                _uiState.value.inputSpending,
                newCategories
            )
        )
    }

    fun createSpending() {
        viewModelScope.launch {
            val lastCheck = addSpendingInteractor.validateMainButtonEnabled(
                _uiState.value.inputSpending,
                _uiState.value.spendingCategories
            )
            if (lastCheck) {
                addSpendingInteractor.createSpending(
                    SpendingModel(
                        id = Random.nextLong(),
                        walletId = currentWalletRepository.currentWalletId,
                        amount = _uiState.value.inputSpending.toFloat(),
                        comment = _uiState.value.inputComment,
                        categoriesId = _uiState.value.spendingCategories.map { it.id },
                        createAt = Calendar.getInstance().time
                    )
                )
                mainDataRefresher.refreshListener?.invoke()
                _systemEvent.value = SystemEvent.DismissDialog
            }
        }
    }
}