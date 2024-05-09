package evgenii.goncharov.econome.wallet_impl.di.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.wallet_api.di.WalletsListApi
import evgenii.goncharov.econome.wallet_impl.di.components.DaggerWalletsListComponent
import javax.inject.Inject

public class WalletsListHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<WalletsListApi>(container) {

    override fun buildComponent(): WalletsListApi {
        return DaggerWalletsListComponent.factory().create()
    }
}