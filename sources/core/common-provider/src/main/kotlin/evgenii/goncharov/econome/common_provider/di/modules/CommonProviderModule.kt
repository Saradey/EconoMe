package evgenii.goncharov.econome.common_provider.di.modules

import dagger.Module
import dagger.Provides
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope
import kotlinx.serialization.json.Json

@Module
internal object CommonProviderModule {

    @Provides
    @CoreScope
    fun provideJson(): Json = Json { ignoreUnknownKeys = true }
}