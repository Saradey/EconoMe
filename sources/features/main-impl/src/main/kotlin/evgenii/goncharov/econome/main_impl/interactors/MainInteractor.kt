package evgenii.goncharov.econome.main_impl.interactors

import evgenii.goncharov.econome.main_impl.models.CurrentUserModel
import evgenii.goncharov.econome.main_impl.models.SpendingItemModel

internal interface MainInteractor {

    fun checkParameters()

    suspend fun formCurrentUser(): CurrentUserModel

    suspend fun formSpendingToday(): String

    suspend fun getCurrentCurrency(): String

    suspend fun getSpendingToday(): List<SpendingItemModel>
}