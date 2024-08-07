package evgenii.goncharov.econome.spending_impl.di.holders

import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.spending_api.di.AddSpendingApi
import evgenii.goncharov.econome.spending_impl.di.components.DaggerAddSpendingComponent
import javax.inject.Inject

public class AddSpendingHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddSpendingApi>(container) {

    override fun buildComponent(): AddSpendingApi {
        return DaggerAddSpendingComponent.factory().create(
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java),
            defaultCategoryApi = getGlobalComponent(DefaultCategoryApi::class.java),
            currentApi = getGlobalComponent(CurrentApi::class.java),
            mainDataRefresher = getFeatureComponent<MainApi>(MainApi::class.java)
                ?.provideMainDataRefresher() ?: initNullableDependence()
        )
    }

    private fun initNullableDependence(): MainDataRefresher {
        return object : MainDataRefresher {
            override var refreshListener: (() -> Unit)? = null

            override fun refreshData() = Unit
        }
    }
}