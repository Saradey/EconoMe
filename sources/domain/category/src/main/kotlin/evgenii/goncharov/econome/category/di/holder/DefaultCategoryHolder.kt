package evgenii.goncharov.econome.category.di.holder

import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.category.di.DaggerDefaultCategoryComponent
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class DefaultCategoryHolder @Inject constructor(
    featureContainer: FeatureContainerManager
) : BaseHolder<DefaultCategoryApi>(featureContainer) {

    override fun buildComponent(): DefaultCategoryApi {
        return DaggerDefaultCategoryComponent.factory().create(
            commonProviderApi = getGlobalComponent(CommonProviderApi::class.java),
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java)
        )
    }
}