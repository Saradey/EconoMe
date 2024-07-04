package evgenii.goncharov.econome.main_impl.dependencies

import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher
import javax.inject.Inject

internal class MainDataRefresherImpl @Inject constructor() : MainDataRefresher {

    override var refreshListener: (() -> Unit)? = null

    override fun refreshData() {
        refreshListener?.invoke()
    }
}