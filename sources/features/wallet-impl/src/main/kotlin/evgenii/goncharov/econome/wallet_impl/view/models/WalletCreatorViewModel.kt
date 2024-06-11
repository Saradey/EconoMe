package evgenii.goncharov.econome.wallet_impl.view.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_impl.models.WalletUiState
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class WalletCreatorViewModel @Inject constructor(
    private val mainNavigationLauncher: MainNavigationLauncher,
    private val walletCreatorRepository: WalletCreatorRepository
) : ViewModel() {

    private val _uiState: MutableState<WalletUiState> = mutableStateOf(
        WalletUiState(
            inputWalletName = "",
            currencies = emptyList(),
            isButtonEnabled = false
        )
    )
    val uiState: State<WalletUiState> = _uiState
    private var currentUserId: String? = null

    init {
        fetchCurrencies()
    }

    fun makeWalletAndNavigationNext() {

//        mainNavigationLauncher.launchReplaceNavigation()

    }

    fun setUserId(userId: String) {
        this.currentUserId = userId
    }

    fun inputWalletName(walletName: String) {
        _uiState.value = _uiState.value.copy(
            inputWalletName = walletName.trim(),
            isButtonEnabled = _uiState.value.currencies.any { it.switch }
        )
        walletCreatorRepository.updateWalletName(walletName)
    }

    fun chooseCurrency(currency: CurrencyCode) {
        _uiState.value = _uiState.value.copy(
            currencies = _uiState.value.currencies.map { model ->
                model.copy(switch = model.code == currency)
            },
            isButtonEnabled = _uiState.value.inputWalletName.isNotEmpty()
        )
        walletCreatorRepository.updateCurrencyCodeSelected(currency)
    }

    private fun fetchCurrencies() {
        viewModelScope.launch {
            val currencies = walletCreatorRepository.formCurrencies()
            _uiState.value = _uiState.value.copy(currencies = currencies)
        }
    }
}