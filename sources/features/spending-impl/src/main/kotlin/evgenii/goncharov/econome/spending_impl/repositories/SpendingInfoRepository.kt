package evgenii.goncharov.econome.spending_impl.repositories

import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel

internal interface SpendingInfoRepository {

    fun getSpendingInfoById() : SpendingInfoModel
}