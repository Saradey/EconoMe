package evgenii.goncharov.econome.wallet_impl.repositories.impl

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.ui_kit.UiKitString
import evgenii.goncharov.econome.wallet_impl.R
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import javax.inject.Inject

internal class WalletCreatorRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore,
    private val resourceManager: ResourceManager,
    private val currencyDataStore: CurrencyDataStore
) : WalletCreatorRepository {

//    override fun formCurrencies(): List<CurrencyModel> {
////        return listOf(
////            CurrencyModel(
////                code = CurrencyCode.RUB,
////                title = resourceManager.getString(R.string.currency_ru_title),
////                switch = false,
////                icon = UiKitString.ic_ru_flag
////            ),
////            CurrencyModel(
////                code = CurrencyCode.EUR,
////                title = resourceManager.getString(R.string.currency_eur_title),
////                switch = false,
////                icon = UiKitString.ic_eur_flag
////            )
////        )
//    }

    override suspend fun formCurrencies(): List<CurrencyModel> {
        TODO("Not yet implemented")
    }
}