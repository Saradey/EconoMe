package evgenii.goncharov.econome.spending_impl.di.holders

import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.spending_api.di.SpendingInfoApi
import evgenii.goncharov.econome.spending_impl.di.components.DaggerSpendingInfoComponent
import javax.inject.Inject

public class SpendingInfoHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<SpendingInfoApi>(container) {

    override fun buildComponentWithParameters(arguments: Map<String, Any?>): SpendingInfoApi {
        return DaggerSpendingInfoComponent.factory().create(
            currentApi = getGlobalComponent(CurrentApi::class.java),
            defaultCategoryApi = getGlobalComponent(DefaultCategoryApi::class.java),
            commonProviderApi = getGlobalComponent(CommonProviderApi::class.java),
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java),
            spendingId = arguments[SPENDING_ID_DI_KEY] as? Long ?: throw IllegalArgumentException(
                SPENDING_KEY_ERROR_MESSAGE
            )
        )
    }

    public companion object {

        public const val SPENDING_ID_DI_KEY: String = "SPENDING_ID_DI_KEY"
        private const val SPENDING_KEY_ERROR_MESSAGE = "Spending id must not be null"
    }
}