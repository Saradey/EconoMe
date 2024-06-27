package evgenii.goncharov.econome.core_database_impl.di.holder

import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.core_database_impl.di.DaggerCoreDatabaseComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class CoreDatabaseHolder @Inject constructor(
    featureContainer: FeatureContainerManager
) : BaseHolder<CoreDatabaseApi>(featureContainer) {

    override fun buildComponent(): CoreDatabaseApi {
        return DaggerCoreDatabaseComponent.builder()
            .commonProviderApi(getGlobalComponent(CommonProviderApi::class.java))
            .build()
    }
}